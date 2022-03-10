package com.jdalvarez.encuesta.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.jdalvarez.encuesta.R

class MainActivity: FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view_tag, SplashFragment())
            }

    
    override fun onBackPressed() {

    }
}