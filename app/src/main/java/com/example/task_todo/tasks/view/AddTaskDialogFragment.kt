package com.example.task_todo.tasks.view

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.task_todo.R
import com.example.task_todo.util.showKeyboard
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.android.support.DaggerDialogFragment

class AddTaskDialogFragment : DaggerDialogFragment() {
    @BindView(R.id.editText_task_details)
    lateinit var userTextInput: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = TextView(context)
        with(title) {
            text = "New Task"
            gravity = Gravity.CENTER
            textSize = 20f
            setPadding(15, 20, 15, 20)
        } // Custom Title to be centered
        val view = View.inflate(
            context,
            R.layout.alertdialog_custom_view,
            null
        ) // Inflate view and pass to dialog builder

        ButterKnife.bind(this, view) // Bind widgets with butterknife

        userTextInput.showKeyboard()
        return MaterialAlertDialogBuilder(activity)
//        Dialog customization options
            .setCustomTitle(title)
            .setView(view)

//                REALLY cheap and crappy hack to get use input back from dialog fragment
            // TODO - You know you'll have to change this.
            .setPositiveButton("Save") { _, _ ->
                val input = userTextInput.text.toString().trim()
                Log.d(AddTaskDialogFragment::class.java.canonicalName, input)
                requireFragmentManager().fragments[0].onActivityResult(
                    targetRequestCode,
                    Activity.RESULT_OK,
                    activity!!.intent.putExtra("input", input)
                )
            }
            .setNegativeButton("Cancel") { _, _ ->
                requireFragmentManager().fragments[0].onActivityResult(
                    targetRequestCode,
                    Activity.RESULT_CANCELED,
                    activity!!.intent
                )
            }
            .create()
    }

}

