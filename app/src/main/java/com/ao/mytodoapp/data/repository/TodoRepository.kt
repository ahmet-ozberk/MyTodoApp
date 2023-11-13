package com.ao.mytodoapp.data.repository

import com.ao.mytodoapp.data.dataSource.TodoDataSource
import com.ao.mytodoapp.data.model.TodoModel

class TodoRepository(var todoDataSource: TodoDataSource) {

    suspend fun allTodos() : List<TodoModel> = todoDataSource.allTodos()

    suspend fun insert(todo:String) = todoDataSource.insert(todo)

    suspend fun delete(todo: TodoModel) = todoDataSource.delete(todo)

    suspend fun update(id: Int, isDone: Int) = todoDataSource.update(id, isDone)
}