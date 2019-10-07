package com.example.task_todo.di.task

import com.example.task_todo.tasks.TaskContract
import com.example.task_todo.tasks.presenter.TaskPresenter
import dagger.Module
import dagger.Provides

@Module
class TaskModule {
    @Provides fun providePresenter(): TaskContract.Presenter<TaskContract.View> {return TaskPresenter()} // Step 2: Provide what to inject
}