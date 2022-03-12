package com.jdalvarez.encuesta.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jdalvarez.encuesta.QuestionVM
import com.jdalvarez.encuesta.databinding.FragmentFormBinding

class FormFragment : Fragment() {
    private lateinit var binding: FragmentFormBinding

    private val vm by activityViewModels<QuestionVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
    }

    private fun setUpUi(){
        binding.siguiente.setOnClickListener{
            vm.email =binding.etEmail.text.toString()
            vm.nombre =binding.etName.text.toString()
            vm.apellido = binding.etLastName.text.toString()
            vm.tel = binding.etDNI.text.toString()

            findNavController().navigate(FormFragmentDirections.actionFormFragmentToQuestion1Fragment())
        }
    }
}