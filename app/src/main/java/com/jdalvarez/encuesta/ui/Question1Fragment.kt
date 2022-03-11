package com.jdalvarez.encuesta.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jdalvarez.encuesta.R
import com.jdalvarez.encuesta.databinding.FragmentQuestion1Binding

class Question1Fragment : Fragment() {
   private lateinit var binding: FragmentQuestion1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestion1Binding.inflate(inflater,container,false)
        return binding.root
    }


}