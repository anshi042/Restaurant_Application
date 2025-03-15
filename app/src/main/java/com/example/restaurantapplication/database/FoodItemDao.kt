package com.example.restaurantapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.restaurantapplication.model.FoodItem

@Dao
interface FoodItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodItem(foodItem: FoodItem)

    @Query("SELECT * FROM food_items")
    fun getAllFoodItems(): LiveData<List<FoodItem>>

    @Query("DELETE FROM food_items")
    suspend fun deleteAllFoodItems()
}
