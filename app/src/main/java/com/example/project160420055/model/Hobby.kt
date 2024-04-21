package com.example.project160420055.model

import com.google.gson.annotations.SerializedName

data class Hobby(
    val id : Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("judul")
    val judul: String,
    @SerializedName("sinopsis")
    val sinopsis: String,
    @SerializedName("urlGambar")
    val urlGambar: String,
    @SerializedName("detail")
    val detail: String
)

