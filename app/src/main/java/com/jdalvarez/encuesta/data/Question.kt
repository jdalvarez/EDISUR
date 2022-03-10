package com.jdalvarez.encuesta.data

import com.jdalvarez.encuesta.data.Answer

data class Question(val id: Int, val text: String, val answers: List<Answer>)