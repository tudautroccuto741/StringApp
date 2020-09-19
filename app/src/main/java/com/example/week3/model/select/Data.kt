package com.example.week3.model.select


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("check_user_sellect")
    val checkUserSellect: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("photoID")
    val photoID: PhotoID,
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String
)