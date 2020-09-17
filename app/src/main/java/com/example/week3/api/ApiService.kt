package com.example.week3.api

import com.example.week3.model.login.LoginData

class ApiService (private val api: Api) {
    fun getLoginIf(
        onPrepared : () -> Unit,
        onSuccess : (LoginData?) -> Unit,
        onError : (String) -> Unit,
        username : String, password :String, fcm_token : String){
        val request = api.userLogin(username, password, fcm_token)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }
}