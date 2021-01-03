package com.example.basalam_interview.Main

import android.util.Log
import androidx.lifecycle.*
import com.example.basalam_interview.Model.Entities.Products
import com.example.basalam_interview.Repositories.ProductsRepository
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val productsRepository: ProductsRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            productsRepository.refreshProducts()
        }
    }

    fun getProducts():LiveData<List<Products>>{
        return productsRepository.getProducts()
    }
}
