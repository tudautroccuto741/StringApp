package com.example.week3.model.feed


import com.google.gson.annotations.SerializedName

data class UrlX(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("thumb")
    val thumb: String
)