package com.example.basalam_interview.Repositories

import Json4Kotlin_Base
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.basalam_interview.Model.Entities.Products
import com.example.basalam_interview.Model.LocalDataSource.ProductsDao
import com.example.basalam_interview.Model.RemoteDataSource.Api_Interface
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject

class ProductsRepository(
    private val productsDao: ProductsDao,
    private val api_interface: Api_Interface
) {

    private lateinit var setProducts: Products

    suspend fun refreshProducts() {
        val rootObject = JsonObject()
        rootObject.addProperty(
            "query",
            "{productSearch(size: 20) {products {id name photo(size: LARGE) { url } vendor { name } weight price rating { rating count: signals } } } }"
        )

        val productsJson = api_interface.getProducts(rootObject)
        val products = Gson().fromJson(productsJson, Json4Kotlin_Base::class.java)

        val productsList = ArrayList<Products>()

        for (item in products.data.productSearch.products) {
            setProducts = Products(
                item.id,
                item.name,
                item.photo.url,
                item.vendor.name,
                item.weight,
                item.price,
                item.rating.rating,
                item.rating.count
            )
            productsList.add(setProducts)
        }

        productsDao.insertProductsList(productsList)
    }

    fun getProducts(): LiveData<List<Products>> {
        return productsDao.getProducts()
    }

}