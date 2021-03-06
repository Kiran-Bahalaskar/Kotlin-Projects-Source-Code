package com.adt.alphadev.firstprojectinkotlin.Retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R
import com.adt.alphadev.firstprojectinkotlin.Retrofit.Models.SignupRequest
import com.adt.alphadev.firstprojectinkotlin.Retrofit.Models.SignupResponse
import com.adt.alphadev.firstprojectinkotlin.Retrofit.Retrofit_Files.ApiService
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var ed_username: TextInputEditText
    private lateinit var ed_email: TextInputEditText
    private lateinit var ed_password: TextInputEditText
    private lateinit var btn_signup: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        ed_username = findViewById(R.id.ed_username) as TextInputEditText
        ed_email = findViewById(R.id.ed_email) as TextInputEditText
        ed_password = findViewById(R.id.ed_password) as TextInputEditText
        btn_signup = findViewById(R.id.btn_signup) as MaterialButton

        btn_signup.setOnClickListener(this::onClick)

    }


     fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_signup -> {
                if (validation()) {
                    val json = JSONObject()
                    json.put("email", ed_email.text.toString())
                    json.put("username", ed_username.text.toString())
                    json.put("password", ed_password.text.toString())

                    ApiService.loginApiCall().doRegister(
                        SignupRequest(
                            ed_email.text.toString(),
                            ed_username.text.toString(), ed_password.text.toString()
                        )
                    ).enqueue(object : Callback<SignupResponse> {
                        override fun onResponse(
                            call: Call<SignupResponse>,
                            response: Response<SignupResponse>
                        ) {

                            Log.d("Response::::", response.body().toString())
                            val loginResponse :  SignupResponse
                            loginResponse = response.body()!!
                            if (loginResponse.status){
                                finish()
                            }else{
                                Toast.makeText(applicationContext, response.body()!!.message, Toast.LENGTH_LONG).show()
                            }
                        }

                        override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                        }

                    })
                }
            }
        }
    }


    fun validation(): Boolean {
        var value = true

        val email = ed_email.text.toString().trim()
        val password = ed_password.text.toString().trim()
        val name = ed_username.text.toString().trim()

        if (email.isEmpty()) {
            ed_email.error = "Email required"
            ed_email.requestFocus()
            value = false
        }


        if (password.isEmpty()) {
            ed_password.error = "Password required"
            ed_password.requestFocus()
            value = false
        }

        if (name.isEmpty()) {
            ed_username.error = "Name required"
            ed_username.requestFocus()
            value = false
        }

        return value;
    }

}