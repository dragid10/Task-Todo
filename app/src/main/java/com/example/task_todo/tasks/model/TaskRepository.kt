package com.example.task_todo.tasks.model

interface TaskRepository {
    fun saveNewTask(taskDetails: String): Task
}