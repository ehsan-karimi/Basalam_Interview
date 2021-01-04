package com.example.basalam_interview.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basalam_interview.repositories.ProductsRepository


class MainViewModelFactory(private var productsRepository: ProductsRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(productsRepository) as T
    }

}