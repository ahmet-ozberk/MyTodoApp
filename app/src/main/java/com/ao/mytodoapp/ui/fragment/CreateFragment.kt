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
import com.ao.mytodoapp.databinding.FragmentCreateBinding
import com.ao.mytodoapp.ui.viewModel.CreateViewModel
import com.ao.mytodoapp.utils.back
import com.ao.mytodoapp.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateFragment : Fragment() {
    private lateinit var binding: FragmentCreateBinding
    private lateinit var viewModel: CreateViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create, container, false)
        optionsToolbar()
        binding.createFragment = this
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CreateViewModel by viewModels()
        viewModel = tempViewModel
    }

    private fun optionsToolbar() {
        binding.createToolbarTitle = getString(R.string.create_todo_toolbar)
        binding.createToolbar.setNavigationIcon(R.drawable.back_icon)
        binding.createToolbar.setNavigationOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
        binding.root.hideKeyboard()
    }

    fun insertTodo(todo:String) {
        viewModel.insertTodo(todo)
        Navigation.back(binding.root)
    }
}