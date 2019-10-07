package com.example.task_todo.di.app

import com.example.task_todo.MainFragment
import com.example.task_todo.di.task.TaskModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class, FragmentModule::class, AppModule::class, TaskModule::class, AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(target: MainFragment) // Step 1:  Where you're going to inject stuff
}