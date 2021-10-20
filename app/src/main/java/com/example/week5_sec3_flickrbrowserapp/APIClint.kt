package com.example.week5_sec3_flickrbrowserapp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClint () {

    private var retrofit: Retrofit? = null
    fun getClient():Retrofit? {
//        val interceptor = HttpLoggingInterceptor() //
//        interceptor.level = HttpLoggingInterceptor.Level.BODY//
//        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()//
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create())
           // .client(client)//
            .build()
        return retrofit
    }











 /*   private lateinit var retrofit: Retrofit

    fun getClient(): Retrofit{

//    val interceptor=HttpLoggingInterceptor()
//    interceptor.level=HttpLoggingInterceptor.Level.BODY
//    val client=OkHttpClient.Builder().addInterceptor(interceptor).build()
//
        retrofit = Retrofit.Builder()

//        .client(client)
            .baseUrl("https://www.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }*/
}
