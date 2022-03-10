package com.jdalvarez.encuesta.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jdalvarez.encuesta.data.Answer
import com.jdalvarez.encuesta.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    private lateinit var binding: FragmentQuestionBinding
    private val viewModel by activityViewModels<QuestionFragmentVM>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleArgs(arguments?.getInt(ARG_QUESTION_ID))
        setupObservers()
    }

    private fun setupAnswers(answers: List<Answer>) {
        answers.forEachIndexed { index, item ->
            val child = RadioButton(context).apply {
                setText(item.text)
            }
            binding.radiogroup.addView(child)
        }
    }

    private fun setupObservers() {
        viewModel.data.observe(viewLifecycleOwner) {
            binding.questionTitle.text = it.text
            setupAnswers(it.answers)
        }
    }

    private fun handleArgs(questionId: Int?) {
        if (questionId != null) {
            viewModel.loadQuestion(questionId)
        } else {
            Log.e(TAG, "Please provide a questionId!! $questionId")
        }
    }


    companion object {
        val ARG_QUESTION_ID = "QUESTION_ID"
        val TAG = QuestionFragment.javaClass.simpleName
    }

}