package com.example.basalam_interview.di.modules

import com.example.basalam_interview.model.localDataSource.ProductsDao
import com.example.basalam_interview.model.remoteDataSource.Api_Interface
import com.example.basalam_interview.repositories.ProductsRepository
import dagger.Module
import dagger.Provides


@Module(includes = [DataBaseModule::class, RetrofitModule::class])
class ProductsRepositoryModule {

    @Provides
    fun getProductsRepository(
        productsDao: ProductsDao,
        api_interface: Api_Interface
    ): ProductsRepository {
        return ProductsRepository(productsDao, api_interface)
    }

}