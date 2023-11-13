package com.ao.mytodoapp.di

import android.content.Context
import androidx.room.Room
import com.ao.mytodoapp.data.dataSource.TodoDataSource
import com.ao.mytodoapp.data.repository.TodoRepository
import com.ao.mytodoapp.room.Database
import com.ao.mytodoapp.room.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTodoDataSource(todoDao:TodoDao) = TodoDataSource(todoDao)

    @Provides
    @Singleton
    fun provideTodoRepository(todoDataSource: TodoDataSource) = TodoRepository(todoDataSource)

    @Provides
    @Singleton
    fun provideTodoDao(@ApplicationContext context: Context):TodoDao{
        val db = Room.databaseBuilder(context,Database::class.java,"todo_db.sqlite")
            .createFromAsset("todo_db.sqlite")
            .build()
        return db.todoDao()
    }
}