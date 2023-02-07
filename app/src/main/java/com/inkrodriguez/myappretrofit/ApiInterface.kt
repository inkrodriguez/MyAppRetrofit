package com.inkrodriguez.myappretrofit

import com.inkrodriguez.myappretrofit.api.Slip
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("advice")
    fun getData(): Call<Slip>

}