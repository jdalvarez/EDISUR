package com.jdalvarez.encuesta.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdalvarez.encuesta.data.Question
import com.jdalvarez.encuesta.data.QuestionsProvider

class QuestionFragmentVM : ViewModel() {
    private val questionsProvider = QuestionsProvider.getInstance()
    private var questionId: Int = 0
    var data = MutableLiveData<Question>()

    fun loadQuestion(id: Int) {
        if (id < questionsProvider.questions.size) {
            questionId = id
            data.postValue(questionsProvider.questions[id])
        } else {
            Log.e(TAG, "Question does not exist! $id")
        }
    }

    companion object {
        val TAG = QuestionFragmentVM.javaClass.simpleName
    }

}