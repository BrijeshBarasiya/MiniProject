package com.example.miniproject

import android.content.Context
import android.content.SharedPreferences

class SessionManagement(con: Context) {

    var pref: SharedPreferences
    var editor: SharedPreferences.Editor

    private var PRIVATE_MODE: Int = 0

    init {
        pref = con.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    companion object {
        val PREF_NAME = "KOtlinDemo"
        val IS_LOGIN = "isLoggedIn"
        const val KEY_NAME = "name"
        const val KEY_EMAIL = "email"
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