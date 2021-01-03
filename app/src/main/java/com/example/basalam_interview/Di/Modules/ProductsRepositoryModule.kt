package com.example.basalam_interview.Di.Modules

import com.example.basalam_interview.Model.LocalDataSource.ProductsDao
import com.example.basalam_interview.Model.RemoteDataSource.Api_Interface
import com.example.basalam_interview.Repositories.ProductsRepository
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