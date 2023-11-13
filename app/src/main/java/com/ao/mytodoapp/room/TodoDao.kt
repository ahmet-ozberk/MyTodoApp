package com.ao.mytodoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ao.mytodoapp.data.model.TodoModel

@Dao
interface TodoDao {

    @Query("SELECT * FROM todos")
    suspend fun allTodos(): List<TodoModel>

    @Insert
    suspend fun insert(todo: TodoModel)

    @Delete
    suspend fun delete(todo: TodoModel)

    @Query("UPDATE todos SET isDone = :isDone WHERE id = :id")
    suspend fun update(id: Int, isDone: Int)
}