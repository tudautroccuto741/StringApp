package com.example.week3.data

import androidx.lifecycle.LiveData

data class Result<T>(
    val data : LiveData<T>,
    val networkState: LiveData<NetworkState>
)