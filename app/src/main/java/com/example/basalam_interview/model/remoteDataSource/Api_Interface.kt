package com.example.basalam_interview.model.remoteDataSource

import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.POST

interface Api_Interface {
    @POST("user")
    suspend fun getProducts(@Body body: JsonObject): JsonObject

}