package com.jdalvarez.encuesta.data

class QuestionsProvider private constructor() {

    val questions = arrayListOf(
        Question(
            0,
            "¿HABÍAS ASISTIDO A OTRAS FERIAS AJÍ?",
            listOf(Answer(0, "SÍ"), Answer(1, "NO"))
        ), Question(
            1,
            "¿TE GUSTÓ QUE ESTA EDICIÓN SE REALICE NUEVAMENTE EN MANANTIALES? [MARCAR UNA RESPUESTA]",
            listOf(Answer(0, "SÍ"), Answer(1, "NO, ¿POR QUÉ?", true))
        )
    )

    companion object {
        private var _instance: QuestionsProvider? = null
        fun getInstance(): QuestionsProvider {
            if (_instance == null) {
                _instance = QuestionsProvider()
            }
            return _instance!!
        }
    }
}