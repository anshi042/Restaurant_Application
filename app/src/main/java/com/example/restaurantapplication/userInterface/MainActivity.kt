package com.example.restaurantapplication.userInterface

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapplication.R
import com.example.restaurantapplication.viewmodel.FoodViewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: FoodViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        viewModel.allFoodItems.observe(this) { foodItems ->
            adapter = FoodListAdapter(foodItems)
            recyclerView.adapter = adapter
        }
    }
}
