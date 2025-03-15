package com.example.restaurantapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.restaurantapplication.database.AppDatabase
import com.example.restaurantapplication.model.FoodItem
import com.example.restaurantapplication.network.RetrofitClient
import com.example.restaurantapplication.api.ApiService
import com.example.restaurantapplication.repository.FoodRepository

class FoodViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FoodRepository
    val allFoodItems: LiveData<List<FoodItem>>

    init {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        repository = FoodRepository(apiService) // ✅ Pass ApiService

        allFoodItems = repository.allFoodItems
    }
}


