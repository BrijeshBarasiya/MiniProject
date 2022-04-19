package com.example.miniproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.miniproject.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private val database = FirebaseFirestore.getInstance()
    private lateinit var binding: ActivityMainBinding
    private lateinit var database2: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database2 = FirebaseDatabase.getInstance().reference

        val user = hashMapOf(
            "firstname" to "Aparna",
            "lastname" to "Tati"
        )

//        database.collection("Users").add(user).addOnSuccessListener { documentReference ->
//            Toast.makeText(this, documentReference.id, Toast.LENGTH_LONG).show()
//        }.addOnFailureListener {
//            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
//        }

        database2 = FirebaseDatabase.getInstance().getReference("Users")
        database2.child("name").setValue(user).addOnSuccessListener {
            Toast.makeText(this, "Data Added!!", Toast.LENGTH_LONG).show()
        }

        database2.child("name").get().addOnCompleteListener {
            Log.d("key", it.result.toString())
            Toast.makeText(applicationContext, it.result.toString(), Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }

    }
}