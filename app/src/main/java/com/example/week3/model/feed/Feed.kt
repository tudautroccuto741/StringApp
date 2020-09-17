package com.example.week3.model.feed


import com.google.gson.annotations.SerializedName

data class Feed(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val feedData: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("status")
    val status: Boolean
)