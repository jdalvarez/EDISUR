package com.jdalvarez.encuesta.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jdalvarez.encuesta.QuestionVM
import com.jdalvarez.encuesta.R
import com.jdalvarez.encuesta.databinding.FragmentQuestion4Binding
import com.jdalvarez.encuesta.databinding.FragmentQuestion5Binding

class Question5Fragment : Fragment() {
    private lateinit var binding: FragmentQuestion5Binding
    private val vm by activityViewModels<QuestionVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestion5Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
    }

    private fun setUpUi() {
        binding.nextQuestion.setOnClickListener {
            vm.p5 = binding.pregunta.text.toString()
            if (binding.chk1.isChecked) vm.r5 = "${vm.r5}, ${binding.chk1.text}"
            if (binding.chk2.isChecked) vm.r5 = "${vm.r5}, ${binding.chk2.text}"
            if (binding.chk3.isChecked) vm.r5 = "${vm.r5}, ${binding.chk3.text}"
            if (binding.chk4.isChecked) vm.r5 = "${vm.r5}, ${binding.chk4.text}"
            if (binding.chk5.isChecked) vm.r5 = "${vm.r5}, ${binding.chk5.text}"
            if (binding.chk6.isChecked) vm.r5 = "${vm.r5}, ${binding.chk6.text}"
            if (binding.chk7.isChecked) vm.r5 = "${vm.r5}, ${binding.chk7.text}"
            findNavController().navigate(Question5FragmentDirections.actionQuestion5FragmentToQuestion6Fragment())
        }
    }
}