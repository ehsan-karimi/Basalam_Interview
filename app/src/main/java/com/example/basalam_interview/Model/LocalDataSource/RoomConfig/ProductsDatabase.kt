package com.example.basalam_interview.Model.LocalDataSource.RoomConfig

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basalam_interview.Model.Entities.Products
import com.example.basalam_interview.Model.LocalDataSource.ProductsDao

@Database(entities = [Products::class], exportSchema = false, version = 1)
abstract class ProductsDatabase:RoomDatabase() {
    abstract fun productsDao(): ProductsDao
}