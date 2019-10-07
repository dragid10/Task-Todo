package com.example.task_todo.tasks.presenter

import com.example.task_todo.tasks.TaskContract
import com.example.task_todo.tasks.model.Task
import com.example.task_todo.tasks.model.TaskManager
import com.example.task_todo.tasks.model.TaskRepository

class TaskPresenter : TaskContract.Presenter<TaskContract.View> {
    private lateinit var view: TaskContract.View
    private val taskManager: TaskRepository = TaskManager()
    override val taskList: ArrayList<Task> = ArrayList()


    override fun startCreateTask() {
        view.showNewTaskPopup()
    }

    override fun saveTaskDetails(taskDetails: String) {
        val savedTask = taskManager.saveNewTask(taskDetails)
        taskList.add(savedTask)
    }

    override fun setView(view: TaskContract.View) {
        this.view = view
    }
}