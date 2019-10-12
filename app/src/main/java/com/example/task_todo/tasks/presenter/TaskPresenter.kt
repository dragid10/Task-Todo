package com.example.task_todo.tasks.presenter

import com.example.task_todo.tasks.TaskContract
import com.example.task_todo.tasks.model.Task
import com.example.task_todo.tasks.model.TaskManager
import com.example.task_todo.util.TASK_DB

class TaskPresenter : TaskContract.Presenter<TaskContract.View> {
    private lateinit var view: TaskContract.View
    private val taskManager: TaskContract.TaskRepository = TaskManager()
    override val taskList: List<Task> = TASK_DB


    override fun startCreateTask() {
        view.showNewTaskPopup()
    }

    override fun saveTaskDetails(taskDetails: String) {
        val savedTask = taskManager.saveNewTask(taskDetails)
    }

    override fun deleteTask(taskNum: Int) {
        taskManager.deleteTask(taskNum)
        view.updateTaskList(taskList)
    }

    override fun setView(view: TaskContract.View) {
        this.view = view
    }
}