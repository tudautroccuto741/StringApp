package com.example.week3.model.select


import com.google.gson.annotations.SerializedName

data class PhotoID(
    @SerializedName("id")
    val id: Int,
    @SerializedName("photo")
    val photo: Photo
)