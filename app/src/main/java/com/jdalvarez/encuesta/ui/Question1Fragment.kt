package com.jdalvarez.encuesta.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.firestore.FirebaseFirestore
import com.jdalvarez.encuesta.QuestionVM
import com.jdalvarez.encuesta.R
import com.jdalvarez.encuesta.databinding.FragmentQuestion1Binding

class Question1Fragment : Fragment() {
    private lateinit var binding: FragmentQuestion1Binding
    private val vm by activityViewModels<QuestionVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestion1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
    }

    private fun setUpUi() {
        binding.nextQuestion.setOnClickListener {
            vm.p1 = binding.pregunta.text.toString()
            if (binding.siAnswer.isChecked) {
                vm.r1 = binding.siAnswer.text.toString()
                findNavController().navigate(Question1FragmentDirections.actionQuestion1FragmentToQuestion2Fragment())
            } else if (binding.noAnswer.isChecked) {
                vm.r1 = binding.noAnswer.text.toString()
                findNavController().navigate(Question1FragmentDirections.actionQuestion1FragmentToQuestion2Fragment())
            } else {
                Toast.makeText(context, "Por favor elija una opcion", Toast.LENGTH_LONG).show()
            }
        }
    }


}