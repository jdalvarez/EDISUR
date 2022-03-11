package com.jdalvarez.encuesta.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jdalvarez.encuesta.R
import com.jdalvarez.encuesta.databinding.FragmentQuestion2Binding

class Question2Fragment : Fragment() {
    private lateinit var binding: FragmentQuestion2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestion2Binding.inflate(inflater,container,false)
        return binding.root
    }

}