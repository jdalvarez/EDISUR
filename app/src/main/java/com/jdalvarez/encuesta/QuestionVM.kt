package com.jdalvarez.encuesta

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class QuestionVM : ViewModel() {

    private val db = FirebaseFirestore.getInstance()

    var nombre: String = ""
    var apellido: String = ""
    var tel: String = ""
    var email: String = ""
    var p1: String = ""
    var r1: String = ""
    var p2: String = ""
    var r2: String = ""
    var p3: String = ""
    var r3: String = ""
    var p4: String = ""
    var r4: String = ""
    var p5: String = ""
    var r5: String = ""
    var p6: String = ""
    var r6: String = ""

    fun save() {
        val validEmail =  if(email.isEmpty()) System.currentTimeMillis().toString() else email
        db.collection("contactos").document(validEmail).set(
            hashMapOf(
                "nombre" to nombre,
                "apellido" to apellido,
                "tel" to tel,
                "email" to  validEmail,
                "p1" to p1,
                "p2" to p2,
                "p3" to p3,
                "p4" to p4,
                "p5" to p5,
                "p6" to p6,
                "r1" to r1,
                "r2" to r2,
                "r3" to r3,
                "r4" to r4,
                "r5" to r5,
                "r6" to r6
            )
        )
    }
}