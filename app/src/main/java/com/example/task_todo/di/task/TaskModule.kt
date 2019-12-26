package com.example.task_todo.di.task

import com.example.task_todo.tasks.model.Task
import com.example.task_todo.util.TASK_DB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
class TaskModule {
    //    @Provides fun providePresenter(): TaskContract.Presenter<TaskContract.View> {return TaskPresenter()} // Step 2: Provide what to inject
    @Provides
    fun provideTaskDB(): MutableList<Task> {
        return TASK_DB
    } // Step 2: Provide what to inject
}