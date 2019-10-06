package com.example.task_todo

import android.app.Application
import com.example.task_todo.di.component.AppComponent
import com.example.task_todo.di.component.DaggerAppComponent
import com.example.task_todo.di.module.AppModule

class MainApplication : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    private fun initDagger(app: MainApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()
}