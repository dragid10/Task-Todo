package com.example.task_todo.di.app

import com.example.task_todo.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector abstract fun contribueMainActivity(): MainActivity
}