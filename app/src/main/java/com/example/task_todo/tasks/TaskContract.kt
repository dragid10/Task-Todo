package com.example.task_todo.tasks

import com.example.task_todo.tasks.model.Task

interface TaskContract {
    interface TaskRepository {
        fun saveNewTask(taskDetails: String): Task
        fun deleteTask(taskNum: Int)

    }

    interface View {
        fun showNewTaskPopup()
        fun updateTaskList(taskList: List<Task>)

    }

    interface Presenter<View> {
        val taskList: List<Task>
        fun saveTaskDetails(taskDetails: String)
        fun startCreateTask()
        fun deleteTask(taskNum: Int)
        fun setView(view: View)
    }
}