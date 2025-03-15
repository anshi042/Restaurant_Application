package com.example.restaurantapplication.utils

import com.example.restaurantapplication.model.Dish

object CartManager {
    private val cartItems = mutableListOf<Dish>()

    fun getCartItems(): List<Dish> = cartItems

    fun addToCart(dish: Dish) {
        if (!cartItems.contains(dish)) {
            cartItems.add(dish)
        }
        dish.increaseQuantity()
    }

    fun removeFromCart(dish: Dish) {
        dish.decreaseQuantity()
        if (dish.quantity == 0) {
            cartItems.remove(dish)
        }
    }

    fun getTotalPrice(): Double {
        return cartItems.sumOf { it.price * it.quantity }
    }
}
