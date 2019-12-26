package com.example.task_todo.tasks.presenter

import com.example.task_todo.tasks.TaskContract
import com.example.task_todo.tasks.model.Task

class TaskPresenter(
    private val view: TaskContract.View,
    private val taskRepository: TaskContract.TaskManager
) : TaskContract.Presenter<TaskContract.View> {
//    private val taskRepository: TaskContract.TaskManager = TaskRepository(TASK_DB)


    override fun startCreateTask() {
        view.showNewTaskPopup()
    }

    override fun saveTaskDetails(taskDetails: String) {
//        val savedTask = taskRepository.saveNewTask(taskDetails)
        taskRepository.saveNewTask(taskDetails)
    }

    override fun deleteTask(taskNum: Int) {
        taskRepository.deleteTask(taskNum)
//        view.updateTaskList(getTaskList())
        view.updateTaskList(getTaskList())
    }

    override fun getTaskList(): List<Task> {
        return taskRepository.getTaskList()
    }
}