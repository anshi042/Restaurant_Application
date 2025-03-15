package com.example.restaurantapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.restaurantapplication.api.ApiService
import com.example.restaurantapplication.model.FoodItem
import com.example.restaurantapplication.model.ItemListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log

class FoodRepository(private val apiService: ApiService) {

    private val _allFoodItems = MutableLiveData<List<FoodItem>>()
    val allFoodItems: LiveData<List<FoodItem>> get() = _allFoodItems

    fun fetchFoodItems() {
        apiService.getFoodItems().enqueue(object : Callback<ItemListResponse> {
            override fun onResponse(call: Call<ItemListResponse>, response: Response<ItemListResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    _allFoodItems.postValue(response.body()!!.items) // Correctly extracting the list
                    Log.d("API_SUCCESS", "Data fetched successfully")
                } else {
                    Log.e("API_ERROR", "Response error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<ItemListResponse>, t: Throwable) {
                Log.e("API_ERROR", "Error fetching food items: ${t.message}")
            }
        })
    }
}


