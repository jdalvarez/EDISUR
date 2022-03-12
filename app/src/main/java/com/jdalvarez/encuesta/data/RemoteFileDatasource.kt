package com.jdalvarez.encuesta.data

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RemoteFileDatasource(val context: Context) {
    fun saveContactData(nombre: String?,
                 apellido: String?,
                 tel: String?,
                 email: String?,
                 p1: String?,
                 p2: String?,
                 p3: String?,
                 p4: String?,
                 p5: String?,
                 p6: String?
    ){
        val db = Firebase.firestore
        email?.let {
            db.collection("users").document(email).set(
                hashMapOf(
                    "nombre" to nombre,
                    "apellido" to apellido,
                    "tel" to tel,
                    "email" to email,
                    "p1" to p1,
                    "p2" to p2,
                    "p3" to p3,
                    "p4" to p4,
                    "p5" to p5,
                    "p6" to p6
                )
            ).addOnFailureListener {
                Log.d("FAIL", it.message.toString())
            }
        }
    }
}