package com.example.task_todo


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.task_todo.tasks.TaskContract
import com.example.task_todo.tasks.model.Task
import com.example.task_todo.tasks.view.TaskListRecyclerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment(), TaskContract.View {
    //    ====================== VARIABLES ======================
    @BindView(R.id.fab_add_task)
    lateinit var addTaskButton: FloatingActionButton

    @BindView(R.id.recyclerView_task_list)
    lateinit var taskRecyclerView: RecyclerView

    @Inject
    lateinit var presenter: TaskContract.Presenter<TaskContract.View> // Step 3: Specify what's being injected

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var taskAdapter: TaskListRecyclerAdapter

    //    ====================== LIFECYCLE METHODS ======================

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this) // Step 4: Add comp that injects everything
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)
        linearLayoutManager = LinearLayoutManager(context)
        taskRecyclerView.layoutManager = linearLayoutManager
        taskAdapter = TaskListRecyclerAdapter(presenter.taskList)
        taskRecyclerView.adapter = taskAdapter
        initListeners()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        Get User input string back from alert dialog
        when (requestCode) {
            0 -> {
                data?.run {
                    if (resultCode == Activity.RESULT_OK) presenter.saveTaskDetails(
                        data.getStringExtra(
                            "input"
                        )
                    )
                }
            }
        }
    }

    //    ====================== CONTRACT METHODS ======================
    override fun showNewTaskPopup() {
        findNavController().navigate(R.id.addTaskDialogFragment)
    }

    override fun updateTaskList(taskList: ArrayList<Task>) {
        taskAdapter.notifyItemInserted(taskList.size - 1)
    }

    //    ====================== METHODS ======================
    private fun initListeners() {
        addTaskButton.setOnClickListener {
            //            Snackbar.make(it, "Test Snack", Snackbar.LENGTH_SHORT).show() todo - Delete
            presenter.startCreateTask()
        }
    }

}
