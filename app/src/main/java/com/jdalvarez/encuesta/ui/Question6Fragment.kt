package com.jdalvarez.encuesta.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jdalvarez.encuesta.QuestionVM
import com.jdalvarez.encuesta.databinding.FragmentQuestion6Binding

class Question6Fragment : Fragment() {
    private lateinit var binding: FragmentQuestion6Binding
    private val vm by activityViewModels<QuestionVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestion6Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
    }

    private fun setUpUi() {
        binding.finalizar.setOnClickListener {
            vm.p6 = binding.pregunta.text.toString()
            if (binding.siAnswer.isChecked) {
                vm.r6 = binding.siAnswer.text.toString()
                vm.save()
                findNavController().navigate(Question6FragmentDirections.actionQuestion6FragmentToThanksFragment())
            } else if (binding.noAnswer.isChecked) {
                vm.r6 = binding.noAnswer.text.toString()
                vm.save()
                findNavController().navigate(Question6FragmentDirections.actionQuestion6FragmentToThanksFragment())
            } else {
                Toast.makeText(context, "Por favor elija una opcion", Toast.LENGTH_LONG).show()
            }
        }
    }
}
