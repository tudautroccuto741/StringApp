package com.example.week3.repository

import androidx.lifecycle.MutableLiveData
import com.example.week3.api.ApiService
import com.example.week3.data.NetworkState
import com.example.week3.data.Result
import com.example.week3.model.login.LoginData

class Repository(private val api : ApiService) : Irepository{
    override fun getLoginIf(username: String, password: String, fcm : String): Result<LoginData> {
        val networkState = MutableLiveData<NetworkState>()
        val responseLogin = MutableLiveData<LoginData>()
        api.getLoginIf(
            username = username,
            password = password,
            fcm_token = fcm,

            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = {response->
                responseLogin.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError ={errMessgae->
                networkState.postValue(NetworkState.error(errMessgae))
            }
        )
        return Result(data = responseLogin, networkState = networkState)
    }
}
