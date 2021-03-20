package com.adt.alphadev.firstprojectinkotlin.Retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R
import com.adt.alphadev.firstprojectinkotlin.Retrofit.Models.UserResponse
import com.adt.alphadev.firstprojectinkotlin.Retrofit.Retrofit_Files.ApiService
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AppCompatActivity() {
    var userId: String = "";

    private lateinit var txt_name: TextView
    private lateinit var txt_email: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setTitle("Home")

        val intent = getIntent()
        userId = intent.getIntExtra("id", 0).toString()

        txt_name = findViewById(R.id.txt_name) as TextView
        txt_email = findViewById(R.id.txt_email) as TextView

        getUser()

    }

    private fun getUser() {
        ApiService.loginApiCall().getUser(userId).enqueue(object: Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                Toast.makeText(this@HomeActivity, response.body().toString(),Toast.LENGTH_SHORT).show()
                if (response.body()!!.status){
                    txt_name.setText(response.body()!!.data.username)
                    txt_email.setText(response.body()!!.data.username)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(this@HomeActivity, t.toString(),Toast.LENGTH_SHORT).show()
            }

        })
    }

}
