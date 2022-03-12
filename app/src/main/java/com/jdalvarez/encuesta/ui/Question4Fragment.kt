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
import com.jdalvarez.encuesta.R
import com.jdalvarez.encuesta.databinding.FragmentQuestion4Binding

class Question4Fragment : Fragment() {
   private lateinit var binding: FragmentQuestion4Binding
   private val vm by activityViewModels<QuestionVM>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestion4Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
    }

    private fun setUpUi() {
        binding.nextQuestion.setOnClickListener {
            vm.p4 = binding.pregunta.text.toString()
            if (binding.siAnswer.isChecked) {
                vm.r4 = binding.siAnswer.text.toString()
                findNavController().navigate(Question4FragmentDirections.actionQuestion4FragmentToQuestion5Fragment())
            } else if(binding.noAnswer.isChecked){
                vm.r4 = "${binding.noAnswer.text}, Porque: ${binding.whyAnswer.text}"
                findNavController().navigate(Question4FragmentDirections.actionQuestion4FragmentToQuestion5Fragment())
            }else if(binding.noSabe.isChecked){
                vm.r4 = binding.noSabe.text.toString()
                findNavController().navigate(Question4FragmentDirections.actionQuestion4FragmentToQuestion5Fragment())
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
                binding.why.visibility = View.GONE
            }
            noAnswer -> {
                binding.why.visibility = View.VISIBLE
                binding.why.invalidate()
            }
            else -> {
                binding.why.visibility = View.GONE
            }
        }
    }

}