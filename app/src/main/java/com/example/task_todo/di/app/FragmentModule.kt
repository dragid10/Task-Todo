package com.example.task_todo.di.app

import com.example.task_todo.MainFragment
import com.example.task_todo.tasks.view.AddTaskDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector abstract fun contributesMainFragment(): MainFragment
    @ContributesAndroidInjector abstract fun contributesAddTaskDialogFragment(): AddTaskDialogFragment
}