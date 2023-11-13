package com.ao.mytodoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.ao.mytodoapp.R
import com.ao.mytodoapp.databinding.FragmentHomeBinding
import com.ao.mytodoapp.ui.adapter.TodoAdapter
import com.ao.mytodoapp.ui.viewModel.HomeViewModel
import com.ao.mytodoapp.utils.to
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.toolbarTitle = getString(R.string.app_name)
        binding.homeFragment = this
        listAction()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabAction(it: View) {
        Navigation.to(it, R.id.homeToCreate)
    }

    fun listAction(){
        viewModel.todoList.observe(viewLifecycleOwner){
            val todoAdapter = TodoAdapter(requireContext(),it,viewModel)
            binding.homeRcView.adapter = todoAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllTodo()
    }
}