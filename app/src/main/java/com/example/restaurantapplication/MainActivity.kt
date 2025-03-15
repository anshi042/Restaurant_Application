package com.example.restaurantapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapplication.Adapters.DishAdapter
import com.example.restaurantapplication.api.ApiService
import com.example.restaurantapplication.model.*
import com.example.restaurantapplication.network.ApiClient
import com.example.restaurantapplication.network.RetrofitClient
import com.example.restaurantapplication.userInterface.FoodListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodListAdapter: FoodListAdapter
    private var foodItems = mutableListOf<FoodItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val btnCart = findViewById<Button>(R.id.btnCart)
        val btnLanguageSwitch = findViewById<Button>(R.id.btnLanguageSwitch)

        val recyclerViewMenuActivity = findViewById<RecyclerView>(R.id.recyclerViewMenu)
        val recyclerViewCartActivity = findViewById<RecyclerView>(R.id.recyclerViewCart
        )

        btnMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        btnCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        btnLanguageSwitch.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"
        toolbar.setTitleTextColor(resources.getColor(android.R.color.white))




        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        foodListAdapter = FoodListAdapter(foodItems)
        recyclerView.adapter = foodListAdapter
        fetchFoodItems()
    }



    private fun fetchFoodItems() {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)

        apiService.getFoodItems().enqueue(object : Callback<ItemListResponse> {
            override fun onResponse(call: Call<ItemListResponse>, response: Response<ItemListResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    foodItems.clear()
                    foodItems.addAll(response.body()!!.items)
                    foodListAdapter.notifyDataSetChanged()
                    Log.d("API_SUCCESS", "Data fetched successfully: ${response.body()!!.items}")
                } else {
                    Log.e("API_ERROR", "Response error: ${response.errorBody()?.string()}")
                    Toast.makeText(this@MainActivity, "API call failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ItemListResponse>, t: Throwable) {
                Log.e("API_ERROR", "Error fetching food items: ${t.message}")
                Toast.makeText(this@MainActivity, "Network error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishAdapter.DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent, false)
        return DishAdapter.DishViewHolder(view)
    }


    private fun makePayment() {
        val apiService = ApiClient.getClient().create(ApiService::class.java)

        val request = PaymentRequest(totalAmount = 400, userId = 5)

        request.addItem(PaymentItem(itemId = 32453, restaurantId = 15234, price = 200, quantity = 1, orderId = 1001))
        request.addItem(PaymentItem(itemId = 32454, restaurantId = 15234, price = 50, quantity = 4, orderId = 1002))

        apiService.makePayment(request).enqueue(object : Callback<PaymentResponse> {
            override fun onResponse(call: Call<PaymentResponse>, response: Response<PaymentResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("API_SUCCESS", "Payment successful: ${response.body()}")
                } else {
                    Log.e("API_ERROR", "Payment failed: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<PaymentResponse>, t: Throwable) {
                Log.e("PAYMENT_ERROR", "Payment request failed: ${t.message}")
            }
        })
    }
}

