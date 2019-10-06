package com.example.task_todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.example.task_todo.tasks.TaskContract
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class MainActivity : AppCompatActivity(), TaskContract.View {


    //    ====================== VARIABLES ======================
    @BindView(R.id.fab_add_task) lateinit var addTaskButton: FloatingActionButton

    @Inject lateinit var presenter: TaskContract.Presenter

    //    ====================== LIFECYCLE METHODS ======================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this) // Bind all view widgets

        initListeners()
    }


    //    ====================== CONTRACT METHODS ======================
//    override fun createTask(taskDetails: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    override fun showNewTaskPopup() {
        TODO("Create popup window here")
        TODO("Get text from popup window here")
        val taskDetailsPlaceholder = "WORDS WORDS WORSD"
        presenter.saveTaskDetails(taskDetailsPlaceholder)
    }

    //    ====================== METHODS ======================
    private fun initListeners() {
        addTaskButton.setOnClickListener {
            Snackbar.make(it, "Test Snack", Snackbar.LENGTH_SHORT).show()
            presenter.startCreateTask()
        }
    }
}
