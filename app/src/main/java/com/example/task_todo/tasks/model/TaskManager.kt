package com.example.task_todo.tasks.model

import com.example.task_todo.util.TASK_DB


class TaskManager : TaskRepository {

    override fun saveNewTask(taskDetails: String): Task {
        val taskToSave = Task(taskDetails)
        TASK_DB.add(taskToSave)
        return taskToSave
    }
}