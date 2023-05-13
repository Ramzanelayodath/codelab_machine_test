package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClientInstance {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://admin.t3al.net/api/v2/"
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}