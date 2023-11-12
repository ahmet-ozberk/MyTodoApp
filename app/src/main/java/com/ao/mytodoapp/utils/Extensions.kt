package com.ao.mytodoapp.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

// Navigation
fun Navigation.to(it:View, id:Int) = findNavController(it).navigate(id)
fun Navigation.to(it:View, id:NavDirections) = findNavController(it).navigate(id)
fun Navigation.back(it:View) = findNavController(it).popBackStack()
fun Navigation.back(it:View, id:Int) = findNavController(it).popBackStack(id, false)

// Hide keyboard
fun View.hideKeyboard() {
    setOnClickListener {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
        clearFocus()
    }
}