package com.ao.mytodoapp.ui.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ao.mytodoapp.R
import com.ao.mytodoapp.data.model.TodoModel
import com.ao.mytodoapp.databinding.TodoCardBinding
import com.ao.mytodoapp.ui.viewModel.HomeViewModel
import com.google.android.material.snackbar.Snackbar

class TodoAdapter(
    val context: Context,
    val todoList: List<TodoModel>,
    val viewModel: HomeViewModel
) : RecyclerView.Adapter<TodoAdapter.TodoAdapter>() {

    inner class TodoAdapter(val design: TodoCardBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter {
        val design: TodoCardBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.todo_card,
            parent,
            false
        )!!
        return TodoAdapter(design)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: TodoAdapter, position: Int) {
        val item = todoList.get(position)
        val design = holder.design

        design.todo = item

        design.completeSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                viewModel.updateTodoById(item.id, 1)
            } else {
                viewModel.updateTodoById(item.id, 0)
            }
        }

        design.todoCardView.setOnLongClickListener {
            Snackbar.make(it, "${item.title} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    viewModel.deleteTodoById(item.id)
                }.setBackgroundTint(Color.RED)
                .setActionTextColor(Color.WHITE)
                .setTextColor(Color.LTGRAY)
                .show()
            true
        }
    }
}