package com.jdalvarez.encuesta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jdalvarez.encuesta.databinding.FragmentHelloScreenBinding
import java.util.zip.Inflater

class HelloScreen : Fragment() {

    private lateinit var binding: FragmentHelloScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHelloScreenBinding.inflate(inflater,container,false)
        return binding.root
    }


}