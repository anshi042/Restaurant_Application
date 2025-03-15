package com.example.restaurantapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import com.example.restaurantapplication.model.Dish

class MenuActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter
    private lateinit var goToCart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_card)

        val dishes = listOf(
            Dish("Burger", 99.00),
            Dish("Pizza", 200.00),
            Dish("Pasta", 150.00),
            Dish("Dosa", 100.00),
            Dish("Rajma Chawal", 80.00),
            Dish("Momos", 50.00),

        )

        recyclerView = findViewById(R.id.recyclerViewMenu)
        goToCart = findViewById(R.id.btnGoToCart)

        menuAdapter = MenuAdapter(this, dishes) {
            // Update UI if needed
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = menuAdapter

        goToCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }
}
