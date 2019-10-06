package com.example.task_todo.di.component

import com.example.task_todo.MainApplication
import com.example.task_todo.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(application: MainApplication)
}