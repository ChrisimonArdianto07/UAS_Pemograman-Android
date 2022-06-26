package com.example.app_catatan.KoneksiDB

import com.example.app_catatan.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    val endpoint: ApiService
        get() {

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.111/API/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
}