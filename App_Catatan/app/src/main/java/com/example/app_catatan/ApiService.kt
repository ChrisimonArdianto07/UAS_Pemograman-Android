package com.example.app_catatan

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    //List Data
    @GET("view_data.php")
    fun data() : Call<Read>

    //Edit Data
    @FormUrlEncoded
    @POST("edit.php")
    fun edit(
        @Field("id") id: String,
        @Field("judul") judul: String,
        @Field("catatan") catatan: String,
        @Field("tgl") tgl: String
    ):Call<KirimInputan>

    //Untuk Delete Data
    @FormUrlEncoded
    @POST("hapus.php")
    fun hapus(
        @Field("id") id: String,
    ):Call<KirimInputan>

    //Tambah Data
    @FormUrlEncoded
    @POST("tambah.php")
    fun tambah(
        @Field("judul") judul: String,
        @Field("catatan") catatan: String,
        @Field("tgl") tgl: String
    ):Call<KirimInputan>




}