package com.example.restaurantapplication.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapplication.R
import com.example.restaurantapplication.model.Dish

class CartAdapter(
    private val context: Context,
    private val cartItems: List<Dish>,
    private val updateCart: () -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = cartItems[position]
        holder.cartDishName.text = dish.name
        holder.cartDishPrice.text = "Rs. ${dish.price} x ${dish.quantity}"
    }

    override fun getItemCount(): Int = cartItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cartDishName: TextView = itemView.findViewById(R.id.cartDishName)
        val cartDishPrice: TextView = itemView.findViewById(R.id.cartDishPrice)
    }
}
