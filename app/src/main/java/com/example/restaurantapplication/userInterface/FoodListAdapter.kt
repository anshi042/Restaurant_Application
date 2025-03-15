package com.example.restaurantapplication.userInterface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurantapplication.R
import com.example.restaurantapplication.model.FoodItem

class FoodListAdapter(private val foodItems: List<FoodItem>) :
    RecyclerView.Adapter<FoodListAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImage: ImageView = itemView.findViewById(R.id.dishImage)
        val foodName: TextView = itemView.findViewById(R.id.dishName)
        val foodPrice: TextView = itemView.findViewById(R.id.dishPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodItem = foodItems[position]
        holder.foodName.text = foodItem.name
        holder.foodPrice.text = "₹${foodItem.price}"

        Glide.with(holder.itemView.context)
            .load(foodItem.imageUrl)
            .into(holder.foodImage)
    }

    override fun getItemCount(): Int = foodItems.size
}
