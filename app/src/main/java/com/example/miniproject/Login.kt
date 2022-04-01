package com.example.miniproject

import Dashboard.UserDashboard
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.miniproject.databinding.ActivityLoginBinding
import java.util.regex.Pattern


class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
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
            val intent = Intent(this, UserDashboard::class.java)
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
                val intent = Intent(this, Registration::class.java)
                startActivity(intent)
            }
        }
    }

}