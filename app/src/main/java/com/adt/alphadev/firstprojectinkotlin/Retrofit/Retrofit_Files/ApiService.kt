package com.adt.alphadev.firstprojectinkotlin.Retrofit.Retrofit_Files

import retrofit2.Retrofit

object ApiService {

    private val TAG = "--ApiService"

    private const val BASE_URL = "http://192.168.43.150/projects/learn_retrofit/"

    fun loginApiCall() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(ApiWorker.gsonConverter)
        .client(ApiWorker.client)
        .build()
        .create(ApiList::class.java)

}