package com.example.app_catatan

import java.io.Serializable

data class Read (
    val hasil : List<Data>
){
    data class Data(
        val id:String?,
        val judul:String?,
        val catatan:String?,
        val tgl:String?
    ): Serializable
}