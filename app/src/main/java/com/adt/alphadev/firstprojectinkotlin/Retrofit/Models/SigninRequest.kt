package com.adt.alphadev.firstprojectinkotlin.Retrofit.Models

import com.google.gson.annotations.SerializedName

class SigninRequest(@SerializedName("email") var email: String, @SerializedName("password") var password: String) {
}