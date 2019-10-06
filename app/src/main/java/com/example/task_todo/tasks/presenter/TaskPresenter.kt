package com.example.task_todo.tasks.presenter

import com.example.task_todo.tasks.TaskContract

class TaskPresenter : TaskContract.Presenter<TaskContract.View> {
    private lateinit var view: TaskContract.View
    override fun startCreateTask() {
        view.showNewTaskPopup()
    }

    override fun saveTaskDetails(taskDetails: String) {
        TODO("Figure out if I should call the repository or model here to save the task")
//        Task(taskDetails).save()
    }

    override fun setView(view: TaskContract.View) {
        this.view = view
    }
}