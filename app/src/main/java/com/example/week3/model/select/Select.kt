package com.example.week3.model.select


import com.google.gson.annotations.SerializedName

data class Select(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("data")
    val selectData: List<Data>? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("metadata")
    val metadata: Metadata? = null,
    @SerializedName("status")
    val status: Boolean? = null
)