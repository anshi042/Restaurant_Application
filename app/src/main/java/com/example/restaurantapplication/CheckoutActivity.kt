package com.example.restaurantapplication

import android.os.Bundle
import android.os.Parcelable
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantapplication.model.Dish


class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val totalPriceTextView = findViewById<TextView>(R.id.totalPriceTextView)

        val cartItems: ArrayList<Dish>? = intent.getParcelableArrayListExtra("cartItems")

        val totalPrice = cartItems?.sumOf { it.price } ?: 0.0
        totalPriceTextView.text = "Total: $${"%.2f".format(totalPrice)}"
    }
}
