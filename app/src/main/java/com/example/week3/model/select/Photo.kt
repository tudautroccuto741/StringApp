package com.example.week3.model.select


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("thumb")
    val thumb: String
)