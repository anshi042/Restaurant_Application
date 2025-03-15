package com.example.restaurantapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapplication.Adapters.CartAdapter
import com.example.restaurantapplication.utils.CartManager

class CartActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var totalAmount: TextView
    private lateinit var checkoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recyclerView = findViewById(R.id.recyclerViewCart)
        totalAmount = findViewById(R.id.totalAmount)
        checkoutButton = findViewById(R.id.orderButton)

        cartAdapter = CartAdapter(this, CartManager.getCartItems()) {
            updateTotalPrice()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = cartAdapter

        updateTotalPrice()

        checkoutButton.setOnClickListener {
            // Handle checkout logic
        }
    }

    private fun updateTotalPrice() {
        totalAmount.text = "Total: Rs. ${CartManager.getTotalPrice()}"
    }
}
