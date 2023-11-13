package com.ao.mytodoapp.data.dataSource

import com.ao.mytodoapp.data.model.TodoModel
import com.ao.mytodoapp.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class TodoDataSource(val todoDao:TodoDao) {

    suspend fun allTodos():List<TodoModel> =
        withContext(Dispatchers.IO){
            return@withContext todoDao.allTodos()
        }

    suspend fun insert(todo:String){
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy - HH:mm", Locale("tr", "TR"))
        val currentDate = currentDateTime.format(formatter)
        todoDao.insert(TodoModel(0,todo, currentDate, 0))
    }

    suspend fun delete(todo: TodoModel){
        todoDao.delete(todo)
    }

    suspend fun update(id: Int, isDone: Int){
        todoDao.update(id, isDone)
    }
}