package com.example.task_todo.di.component

import com.example.task_todo.di.module.TaskModule
import dagger.Component

@Component(modules = [TaskModule::class])
interface TaskComponent {
//    fun inject(view: TaskContract.View)
//    fun inject(presenter: TaskContract.Presenter<TaskContract.View>)
}