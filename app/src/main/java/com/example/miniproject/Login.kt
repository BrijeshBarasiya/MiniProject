package com.example.miniproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.miniproject.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class Login : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
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

        validateEdittext(binding.emailEdittext, binding.email)
        validateEdittext(binding.passwordEdittext, binding.password)

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
            }
        }
    }

    private fun validateEdittext(editText: EditText, txtLayout: TextInputLayout) {
        editText.doOnTextChanged { text, _, _, _ ->
            if (text != "") {
                txtLayout.error = null
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
                    Toast.
                    makeText(this,"Error message: ${task.exception!!.message.toString()}", Toast.LENGTH_SHORT).show()
                }
            }
    }

}