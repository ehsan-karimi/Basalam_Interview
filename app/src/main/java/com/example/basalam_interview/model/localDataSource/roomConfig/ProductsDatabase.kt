package com.example.basalam_interview.model.localDataSource.roomConfig

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basalam_interview.model.entities.Products
import com.example.basalam_interview.model.localDataSource.ProductsDao

@Database(entities = [Products::class], exportSchema = false, version = 1)
abstract class ProductsDatabase:RoomDatabase() {
    abstract fun productsDao(): ProductsDao
}