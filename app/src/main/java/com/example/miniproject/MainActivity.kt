package com.example.miniproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.miniproject.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private val database = FirebaseFirestore.getInstance()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = hashMapOf(
            "firstname" to "Rishita",
            "lastname" to "Panchal"
        )

        var check = false
        database.collection("Users").add(user).addOnSuccessListener { documentReference ->
            Log.d("Success", documentReference.id)
            Toast.makeText(this, documentReference.id, Toast.LENGTH_LONG).show()
            Log.d("success", "db")
            check =  true
        }.addOnFailureListener {
            Log.d("failure", it.stackTraceToString())
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }

    }
}