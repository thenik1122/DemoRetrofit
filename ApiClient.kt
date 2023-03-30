package com.example.sharedpreference.apiretrofit.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        retrofit = Retrofit.Builder()

            .baseUrl("http://smartfoodery.oneapp.ro/smart_food/public/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}