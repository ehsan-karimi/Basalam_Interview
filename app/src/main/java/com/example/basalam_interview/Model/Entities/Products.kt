package com.example.basalam_interview.Model.Entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_products")
data class Products(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val name: String,
    val photo: String,
    val vendor: String,
    val weight: Int,
    val price: Int,
    val rating: Float,
    val ratingCount: Int
)

