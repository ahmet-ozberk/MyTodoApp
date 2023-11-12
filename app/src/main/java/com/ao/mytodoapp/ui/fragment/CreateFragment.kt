package com.ao.mytodoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ao.mytodoapp.R
import com.ao.mytodoapp.databinding.FragmentCreateBinding
import com.ao.mytodoapp.utils.hideKeyboard

class CreateFragment : Fragment() {
    private lateinit var binding: FragmentCreateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateBinding.inflate(inflater, container, false)
        optionsToolbar()
        binding.createFragment = this
        return binding.root
    }

    private fun optionsToolbar() {
        binding.createToolbarTitle = getString(R.string.create_todo_toolbar)
        binding.createToolbar.setNavigationIcon(R.drawable.back_icon)
        binding.createToolbar.setNavigationOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
        binding.root.hideKeyboard()
    }

    fun createTodo(){
        Log.e("Create Todo Button", "createTodo", )
    }
}