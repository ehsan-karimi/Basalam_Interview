package com.example.basalam_interview.main

import androidx.lifecycle.*
import com.example.basalam_interview.model.entities.Products
import com.example.basalam_interview.repositories.ProductsRepository
import kotlinx.coroutines.*

class MainViewModel(private val productsRepository: ProductsRepository) : ViewModel() {

    val liveDataError = MutableLiveData<Throwable>()

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        liveDataError.postValue(throwable)
    }

    init {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler){
            productsRepository.refreshProducts()
        }
    }

    fun getProducts():LiveData<List<Products>>{
        return productsRepository.getProducts()
    }
}
