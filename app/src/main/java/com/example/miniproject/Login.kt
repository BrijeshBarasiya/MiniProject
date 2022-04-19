package com.example.miniproject

import Dashboard.UserDashboard
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.miniproject.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.regex.Pattern


class Login : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var refUser: DatabaseReference
    private var firebaseId: String =  ""
    private lateinit var binding: ActivityLoginBinding
    lateinit var session: SessionManagement
    lateinit var pre: SharedPreferences
    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    val PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManagement(applicationContext)
        pre = getSharedPreferences("KOtlinDemo", MODE_PRIVATE)
       if(session.isLogin()) {
            val i = Intent(applicationContext, ItemsList::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }
        mAuth = FirebaseAuth.getInstance()

        binding.baseLayout.setOnClickListener {
            if (currentFocus != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }
        }

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

        binding.goToSignup.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }

        binding.signInButton.setOnClickListener {
            if (binding.emailEdittext.text.toString() == "" && binding.passwordEdittext.text.toString() == "") {
                binding.email.error = "Required*"
                binding.password.error = "Required*"
            } else if(!EMAIL_ADDRESS_PATTERN.matcher(binding.emailEdittext.text!!).matches()) {
               binding.email.error = "Invalid Email id"
               Log.d("msg", binding.emailEdittext.text.toString())
            } else {
                binding.email.error = null
                binding.password.error = null
                loginUser()
                //val intent = Intent(this, Registration::class.java)
                //startActivity(intent)
            }
        }
    }

    private fun loginUser() {
        val email = binding.emailEdittext.text.toString()
        val password = binding.passwordEdittext.text.toString()

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    session.createLoginSession(email)
                    val intent = Intent(this, ItemsList::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                } else {
                    Toast.makeText(this,"Error message: ${task.exception!!.message.toString()}", Toast.LENGTH_SHORT).show()
                }
            }
    }

}