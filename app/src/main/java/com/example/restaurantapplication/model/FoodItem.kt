package com.example.restaurantapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_items")
data class FoodItem(
    @PrimaryKey val itemId: Int,
    val name: String,
    val imageUrl: String,
    val price: Double,
    val rating: Double,
    val cuisineId: Int,
    val cuisineName: String
)


