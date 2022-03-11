package com.jdalvarez.encuesta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jdalvarez.encuesta.databinding.FragmentThanksBinding

class Thanks : Fragment() {
    private lateinit var binding: FragmentThanksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentThanksBinding.inflate(inflater,container,false)
        return binding.root
    }

}