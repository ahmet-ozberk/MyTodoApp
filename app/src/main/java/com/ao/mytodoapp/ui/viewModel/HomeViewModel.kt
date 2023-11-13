package com.ao.mytodoapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ao.mytodoapp.data.model.TodoModel
import com.ao.mytodoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val todoRepository: TodoRepository) : ViewModel() {

    val todoList = MutableLiveData<List<TodoModel>>()

    init {
        getAllTodo()
    }

    fun getAllTodo() {
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value = todoRepository
                .allTodos()
                .sortedByDescending { value ->
                    val formattedDate = value.date
                    val formatter =
                        DateTimeFormatter.ofPattern("dd MMMM yyyy - HH:mm", Locale("tr", "TR"))
                    val localDateTime = LocalDateTime.parse(formattedDate, formatter)
                    localDateTime
                }

        }
    }

    fun deleteTodoById(todoId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.delete(TodoModel(todoId, "", "", 0))
            getAllTodo()
        }
    }

    fun updateTodoById(todoId: Int, isDone: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.update(todoId, isDone)
        }
    }
}