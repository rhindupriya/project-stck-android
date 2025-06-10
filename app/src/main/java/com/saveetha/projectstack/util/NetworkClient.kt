package com.saveetha.projectstack.util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY  // Log request and response body
    }

    private val client = OkHttpClient.Builder()
//        .addInterceptor(AuthInterceptor())  // Add custom interceptor
        .addInterceptor(loggingInterceptor) // Add logging interceptor
        .build()

    val api: Service by lazy {
        Retrofit.Builder()
            .baseUrl(Constance.BASE_URL)  // Change to your API base URL
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service::class.java)
    }
}