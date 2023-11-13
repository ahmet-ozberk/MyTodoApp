package com.ao.mytodoapp.ui.viewModel

import androidx.lifecycle.ViewModel
import com.ao.mytodoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(val todoRepository: TodoRepository) : ViewModel() {

    fun insertTodo(todo:String){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.insert(todo)
        }
    }
}