package com.ao.mytodoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ao.mytodoapp.data.model.TodoModel

@Database(entities = [TodoModel::class],version = 1)
abstract class Database:RoomDatabase() {
    abstract fun todoDao():TodoDao
}