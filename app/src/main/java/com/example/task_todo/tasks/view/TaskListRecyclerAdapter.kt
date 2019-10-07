package com.example.task_todo.tasks.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task_todo.R
import com.example.task_todo.tasks.model.Task
import com.example.task_todo.util.inflate
import kotlinx.android.synthetic.main.recyclerview_task.view.*

class TaskListRecyclerAdapter(private val tasks: ArrayList<Task>) :
    RecyclerView.Adapter<TaskListRecyclerAdapter.ViewHolder>() {
    //    ====================== VARIABLES ======================
    //    ====================== LIFECYCLE METHODS ======================
    //    ====================== CONTRACT METHODS ======================
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_task, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val taskItem = tasks[position]
        holder.bindTask(taskItem)
    }//    ====================== METHODS ======================

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        private var task: Task? = null

        fun bindTask(task: Task) {
            this.task = task
            view.textview_task.text = task.taskDetails
        }
    }

}
