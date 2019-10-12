package com.example.task_todo

import com.example.task_todo.di.app.AppComponent
import com.example.task_todo.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MainApplication : DaggerApplication() {
    //    ====================== VARIABLES ======================
    lateinit var appComponent: AppComponent

    //    ====================== LIFECYCLE METHODS ======================

    //    ====================== CONTRACT METHODS ======================
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().build()
        appComponent.inject(this)
        return appComponent
    }

    //    ====================== METHODS ======================
}