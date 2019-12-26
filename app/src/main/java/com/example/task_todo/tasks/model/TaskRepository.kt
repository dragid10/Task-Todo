package com.example.task_todo.tasks.model

import com.example.task_todo.tasks.TaskContract
import com.example.task_todo.util.TASK_DB


class TaskRepository :
TaskContract.TaskManager {
    val taskDB: MutableList<Task> = TASK_DB

    override fun getTaskList(): List<Task> {
        return taskDB
    }

    override fun saveNewTask(taskDetails: String): Task {
        val taskToSave = Task(taskDetails)
        taskDB.add(taskToSave)
        return taskToSave
    }

    override fun deleteTask(taskNum: Int) {
        taskDB.removeAt(taskNum)
    }
}