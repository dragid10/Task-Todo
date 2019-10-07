package com.example.task_todo.tasks

import com.example.task_todo.tasks.model.Task

interface TaskContract {
    interface Model {
//        fun saveNewTask(newTask: Task)
    }

    interface View {
        fun showNewTaskPopup()
        fun updateTaskList(taskList: ArrayList<Task>)

    }

    interface Presenter<View> {
        val taskList: ArrayList<Task>
        fun saveTaskDetails(taskDetails: String)
        fun startCreateTask()
        fun setView(view: View)
    }
}