package com.example.task_todo.di.component

import com.example.task_todo.di.module.TaskModule
import com.example.task_todo.tasks.TaskContract
import dagger.Component

@Component(modules = arrayOf(TaskModule::class))
interface TaskComponent {
    fun inject(view: TaskContract.View)
}