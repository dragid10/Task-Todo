package com.example.task_todo.tasks.model

import com.example.task_todo.tasks.TaskContract
import com.example.task_todo.util.TASK_DB


class TaskManager : TaskContract.TaskRepository {

    override fun saveNewTask(taskDetails: String): Task {
        val taskToSave = Task(taskDetails)
        TASK_DB.add(taskToSave)
        return taskToSave
    }

    override fun deleteTask(taskNum: Int) {
        TASK_DB.removeAt(taskNum)
    }
}