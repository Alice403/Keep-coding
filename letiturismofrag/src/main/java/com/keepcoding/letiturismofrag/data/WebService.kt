package com.keepcoding.letiturismofrag.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



//El profesor le llamo APIFactory al objeto
object WebService {
    private const val urlAPI = "https://my-json-server.typicode.com/"

    private val okkHttpClient=OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    val retrofit:ApiService = Retrofit.Builder()
        .baseUrl(urlAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okkHttpClient)
        .build()
        .run{
            create(ApiService::class.java)
        }

}