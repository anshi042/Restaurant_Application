package com.example.restaurantapplication.model

data class TransactionResponse(
    val transactionId: String,
    val status: String,
    val timestamp: String
)
