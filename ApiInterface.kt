package com.example.sharedpreference.apiretrofit.utils

import com.example.sharedpreference.apiretrofit.model.MainModel
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("user_order_detail/38")
    fun getUser(): Call<MainModel>
}