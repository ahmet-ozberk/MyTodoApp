package com.ao.mytodoapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "todos")
data class TodoModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") @NotNull var id: Int,
    @ColumnInfo(name = "todo") @NotNull var title: String,
    @ColumnInfo(name = "date") @NotNull var date: String,
    @ColumnInfo(name = "isDone") @NotNull var isDone: Int
)
