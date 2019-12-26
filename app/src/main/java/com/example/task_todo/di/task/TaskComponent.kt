package com.example.task_todo.di.task

import com.example.task_todo.tasks.TaskContract
import dagger.Component

@Component(modules = [TaskModule::class])
interface TaskComponent {
//    fun inject(view: TaskContract.View)
    fun inject(presenter: TaskContract.Presenter<TaskContract.View>)
}