package com.example.restaurantapplication.model

import com.google.gson.annotations.SerializedName

data class ItemListResponse(
    @SerializedName("items") val items: List<FoodItem> = emptyList() // Ensure this matches API JSON response
)




