package com.example.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.miniproject.databinding.ActivityLoginBinding
import com.example.miniproject.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.math.BigInteger
import java.security.MessageDigest
import java.util.regex.Pattern
import javax.crypto.spec.PBEKeySpec

class Registration : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    lateinit var session: SessionManagement
    private lateinit var refUser: DatabaseReference
    private var firebaseId: String =  ""
    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAuth = FirebaseAuth.getInstance()
        binding.emailEdittext.doOnTextChanged { text, start, before, count ->
            if (text != "") {
                binding.email.error = null
            }
        }

        binding.passwordEdittext.doOnTextChanged { text, start, before, count ->
            if (text != "") {
                binding.password.error = null
            }
        }

        binding.confirmPasswordEdittext.doOnTextChanged { text, start, before, count ->
            if (text != "") {
                binding.confirmPassword.error = null
            }
        }

        binding.goToSignin.setOnClickListener {
           val intent = Intent(this, Login::class.java)
           startActivity(intent)
        }

        binding.signUpButton.setOnClickListener {
            if (binding.emailEdittext.text.toString() == "" || binding.passwordEdittext.text.toString() == "" || binding.confirmPasswordEdittext.text.toString() == "") {
                binding.email.error = "Required*"
                binding.password.error = "Required*"
                binding.confirmPassword.error = "Required*"
            } else if(!EMAIL_ADDRESS_PATTERN.matcher(binding.emailEdittext.text!!).matches()) {
                binding.email.error = "Invalid Email id"
                Log.d("msg", binding.emailEdittext.text.toString())
            }  else if ( binding.passwordEdittext.text.toString() != binding.confirmPasswordEdittext.text.toString()) {
                binding.confirmPassword.error = "Passwords mismatch!"
            } else {
               registerUser()
            }
        }
    }

    private fun registerUser() {
        val userName = binding.usernameEdittext.text.toString()
        val email = binding.emailEdittext.text.toString()
        val password = binding.passwordEdittext.text.toString()
        fun md5(input:String): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
        val md5Password = md5(password)
        Log.d("new pass", md5Password)
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful) {
                firebaseId = mAuth.currentUser!!.uid
                refUser = FirebaseDatabase.getInstance().reference.child("UsersDetails").child(firebaseId)
                val userHashmap = HashMap<String, Any>()
                userHashmap["username"] = userName
                userHashmap["uid"] = firebaseId
                userHashmap["email"] = email
                userHashmap["password"] = md5Password
                refUser.updateChildren(userHashmap)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful) {
                            val intent = Intent(this, Login::class.java)
                            startActivity(intent)
                        }
                        else {
                            Toast.makeText(this,"Failure", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this,"Error message: ${task.exception!!.message.toString()}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}