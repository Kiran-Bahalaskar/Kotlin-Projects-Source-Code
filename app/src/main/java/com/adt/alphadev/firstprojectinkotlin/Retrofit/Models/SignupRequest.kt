package com.adt.alphadev.firstprojectinkotlin.Retrofit.Models

import com.google.gson.annotations.SerializedName

class SignupRequest(
    @SerializedName("email") var email: String,
    @SerializedName("username") var username: String,
    @SerializedName("password") var password: String
) {
}