package com.example.task_todo.tasks.view

import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.task_todo.R
import com.example.task_todo.tasks.model.Task
import com.example.task_todo.util.inflate

class TaskListRecyclerAdapter(
    private val tasks: List<Task>,
    val clickListener: OnTaskClickListener
) :
    RecyclerView.Adapter<TaskListRecyclerAdapter.ViewHolder>() {
    //    ====================== VARIABLES ======================
    //    ====================== LIFECYCLE METHODS ======================
    //    ====================== CONTRACT METHODS ======================
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
//         Inflate recyclerview
        val inflatedView = parent.inflate(R.layout.recyclerview_task, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Bind the tasks to the task view list
        holder.bindTask(tasks[position])

//        Pass click back to view (Fragment)
        holder.imageButtonDeleteTask.setOnClickListener {
            clickListener.onTaskClick(position)
        }
    }
    // ====================== METHODS ======================

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        @BindView(R.id.textview_task)
        lateinit var textviewTask: TextView
        @BindView(R.id.imageButton_delete_task)
        lateinit var imageButtonDeleteTask: ImageButton

        init {
            ButterKnife.bind(this, v)
        }

        fun bindTask(
            task: Task
        ) {
//            Set task details to task textview
            textviewTask.text = task.taskDetails
        }
    }

//    Deefine click listener interface for fragment to implement
    interface OnTaskClickListener {
        fun onTaskClick(taskPosition: Int)
    }

}
