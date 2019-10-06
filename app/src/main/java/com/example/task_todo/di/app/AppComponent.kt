package com.example.task_todo.di.component

import com.example.task_todo.MainActivity
import com.example.task_todo.di.module.AppModule
import com.example.task_todo.di.module.TaskModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, TaskModule::class])
interface AppComponent {
    fun inject(target: MainActivity) // Step 1:  Where you're going to inject stuff
}