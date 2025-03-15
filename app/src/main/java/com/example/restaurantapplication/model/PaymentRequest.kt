package com.example.restaurantapplication.model

data class PaymentRequest(
    val totalAmount: Int, // FIX: "amount" -> "totalAmount"
    val userId: Int // FIX: "user_id" -> "userId"
) {
    val items: MutableList<PaymentItem> = mutableListOf()

    fun addItem(item: PaymentItem) {
        items.add(item)
    }
}


