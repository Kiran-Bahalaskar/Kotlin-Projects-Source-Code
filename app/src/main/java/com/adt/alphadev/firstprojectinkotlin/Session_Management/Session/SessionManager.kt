package com.adt.alphadev.firstprojectinkotlin.Session_Management.Session

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.adt.alphadev.firstprojectinkotlin.Session_Management.ActivitySession_Management

class SessionManager {

    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var con: Context
    var PRIVATEMODE: Int = 0

    constructor(con: Context) {
        this.con = con
        pref = con.getSharedPreferences(PREF_NAME, PRIVATEMODE)
        editor = pref.edit()
    }

    companion object{

        val PREF_NAME = "Login_Preference"
        val IS_LOGIN = "isLoggedin"
        val KEY_NAME = "name"
        val KEY_EMAIL = "email"

    }

    fun createLoginSession(name: String, email: String){
        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_EMAIL, email)
        editor.commit()
    }

    fun checkLogin(){
        if (!this.isLoggedIn()){
            var i : Intent = Intent(con, ActivitySession_Management::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            con.startActivity(i)
        }
    }

    fun getUserDetails(): HashMap<String, String>{
        var user: Map<String, String> = HashMap<String, String>()
        (user as HashMap).put(KEY_NAME, pref.getString(KEY_NAME,null)!!)
        (user as HashMap).put(KEY_EMAIL, pref.getString(KEY_EMAIL,null)!!)
        return user
    }

    fun LogoutUser(){
        editor.clear()
        editor.commit()
        var i : Intent = Intent(con, ActivitySession_Management::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        con.startActivity(i)
    }

    fun isLoggedIn(): Boolean{
        return pref.getBoolean(IS_LOGIN,false)
    }

}