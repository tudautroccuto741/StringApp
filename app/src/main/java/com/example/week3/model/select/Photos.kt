package com.example.week3.model.select


import com.google.gson.annotations.SerializedName

data class Photos(
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: Url
)