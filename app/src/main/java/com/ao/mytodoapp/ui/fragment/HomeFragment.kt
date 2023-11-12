package com.ao.mytodoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ao.mytodoapp.R
import com.ao.mytodoapp.databinding.FragmentHomeBinding
import com.ao.mytodoapp.utils.to

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.toolbarTitle = getString(R.string.app_name)
        binding.homeFragment = this
        return binding.root
    }

    fun fabAction(it: View) {
        Navigation.to(it, R.id.homeToCreate)
    }
}