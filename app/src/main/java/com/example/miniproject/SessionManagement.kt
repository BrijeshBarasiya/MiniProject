package com.example.miniproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

class SessionManagement(var con: Context) {
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor
    var PRIVATE_MODE: Int = 0

    init {
        pref = con.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    companion object {
        val PREF_NAME = "KOtlinDemo"
        val IS_LOGIN = "isLoggedIn"
        val KEY_NAME = "name"
        val KEY_EMAIL = "email"
    }

    fun createLoginSession(email: String)  {
        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_EMAIL, email)
        editor.commit()
    }

    fun logOutUser() {
        editor.clear()
        editor.commit()
    }

    fun isLogin(): Boolean {
        return pref.getBoolean(IS_LOGIN, false)
    }

}