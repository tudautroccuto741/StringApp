package com.example.week3.viewModel

import androidx.lifecycle.*
import com.example.week3.model.login.LoginData
import com.example.week3.repository.Repository
import com.example.week3.data.Result
import com.example.week3.repository.Irepository

class StringViewModel(private val repository: Irepository): ViewModel(){
    private val requestLogin = MutableLiveData<Result<LoginData>>()

    val loginIf =Transformations.switchMap(requestLogin){
        it.data
    }

    fun getLoginIf(username : String, pass : String, fcm : String)
    {
        requestLogin.value = repository.getLoginIf(username, pass, fcm)
    }
}

class StringViewModelFactory(
    private val repository : Irepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = StringViewModel(repository) as T
}