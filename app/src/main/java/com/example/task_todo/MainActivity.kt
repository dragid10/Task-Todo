package com.example.task_todo

import android.os.Bundle
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {


    //    ====================== VARIABLES ======================

    //    ====================== LIFECYCLE METHODS ======================

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this) // Inject the activity with Dagger
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    //    ====================== CONTRACT METHODS ======================

    //    ====================== METHODS ======================
}
