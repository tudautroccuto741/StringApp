package com.example.week2.di

import androidx.lifecycle.ViewModelProvider


//ViewModelProvider
import com.example.week3.api.Api
import com.example.week3.api.ApiService
import com.example.week3.repository.Irepository
import com.example.week3.repository.Repository
import com.example.week3.viewModel.StringViewModelFactory

object Injection {
    private fun provideNewsRepository() : Irepository {
        return Repository(provideApiService())
    }

    private fun provideApiService() : ApiService {
        return ApiService(Api.create())
    }

    fun provideViewModelFactory() : ViewModelProvider.Factory{
        return StringViewModelFactory(provideNewsRepository())
    }
}