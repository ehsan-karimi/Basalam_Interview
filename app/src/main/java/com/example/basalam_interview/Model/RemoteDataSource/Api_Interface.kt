package com.example.basalam_interview.Model.RemoteDataSource

import com.example.basalam_interview.Model.Entities.Products
import com.google.gson.JsonObject
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface Api_Interface {
    @POST("user")
    suspend fun getProducts(@Body body: JsonObject): JsonObject

}