package com.example.restaurantapplication.model

data class PaymentItem(
    val itemId: Int, // FIX: "item_id" -> "itemId"
    val restaurantId: Int, // FIX: "restaurant_id" -> "restaurantId"
    val price: Int,
    val quantity: Int,
    val orderId: Int // FIX: Ensure orderId is included
)


