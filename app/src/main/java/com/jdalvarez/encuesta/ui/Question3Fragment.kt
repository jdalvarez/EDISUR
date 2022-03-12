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
import com.jdalvarez.encuesta.databinding.FragmentQuestion3Binding

class Question3Fragment : Fragment() {
  private lateinit var binding: FragmentQuestion3Binding
  private val vm by activityViewModels<QuestionVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestion3Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
    }

    private fun setUpUi() {
        binding.chkGroup.visibility = View.GONE
        binding.nextQuestion.setOnClickListener {
            vm.p3 = binding.pregunta.text.toString()
            if (binding.siAnswer.isChecked) {
                vm.r3 = binding.siAnswer.text.toString()
                if(binding.chk1.isChecked) vm.r3 = "${vm.r3}, ${binding.chk1.text}"
                if(binding.chk2.isChecked) vm.r3 = "${vm.r3}, ${binding.chk2.text}"
                if(binding.chk3.isChecked) vm.r3 = "${vm.r3}, ${binding.chk3.text}"
                if(binding.chk4.isChecked) vm.r3 = "${vm.r3}, ${binding.chk4.text}"
                if(binding.chk5.isChecked) vm.r3 = "${vm.r3}, ${binding.chk5.text}"
                findNavController().navigate(Question3FragmentDirections.actionQuestion3FragmentToQuestion4Fragment())
            } else if(binding.noAnswer.isChecked) {
                vm.r3 = "${binding.noAnswer.text}"
                findNavController().navigate(Question3FragmentDirections.actionQuestion3FragmentToQuestion4Fragment())
            } else {
                Toast.makeText(context, "Por favor elija una opcion", Toast.LENGTH_LONG).show()
            }

        }

        binding.siAnswer.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) showHideExtraOptions(siAnswer = true)
        }
        binding.noAnswer.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) showHideExtraOptions(noAnswer = true)
        }
    }

    private fun showHideExtraOptions(siAnswer: Boolean = false, noAnswer: Boolean = false) {
        when {
            siAnswer -> {
                binding.chkGroup.visibility = View.VISIBLE
            }
            noAnswer -> {
                binding.chkGroup.visibility = View.GONE
            }
            else -> {
                binding.chkGroup.visibility = View.GONE
            }
        }
    }






}