package com.example.task_todo.tasks

interface TaskContract {
    interface Model {
//        fun saveNewTask(newTask: Task)
    }

    interface View {
        //        fun setPresenter(presenter: TaskContract.Presenter) - Method injection should not be used for top-level components
        fun showNewTaskPopup()
//        fun createTask(taskDetails: String)
    }

    interface Presenter<View> {
        fun saveTaskDetails(taskDetails: String)
        fun startCreateTask()
        fun setView(view: View)
    }
}