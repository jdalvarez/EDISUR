package com.jdalvarez.encuesta.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.jdalvarez.encuesta.R

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {}
}