package com.example.basalam_interview.model.localDataSource

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basalam_interview.model.entities.Products

@Dao
interface ProductsDao {

    @Query("SELECT * FROM tbl_products")
    fun getProducts(): LiveData<List<Products>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductsList(products: List<Products>)

}