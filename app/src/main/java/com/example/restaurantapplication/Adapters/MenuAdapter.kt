package com.example.restaurantapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapplication.model.Dish
import com.example.restaurantapplication.utils.CartManager

class MenuAdapter(
    private val context: Context,
    private val dishes: List<Dish>,
    private val updateCart: () -> Unit // Callback to update the UI
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_dish, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = dishes[position]
        holder.dishName.text = dish.name
        holder.dishPrice.text = "Rs. ${dish.price}"
        holder.dishQuantity.text = dish.quantity.toString()

        holder.addButton.setOnClickListener {
            CartManager.addToCart(dish)
            notifyItemChanged(position)
            updateCart()
        }

        holder.minusButton.setOnClickListener {
            CartManager.removeFromCart(dish)
            notifyItemChanged(position)
            updateCart()
        }
    }

    override fun getItemCount(): Int = dishes.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dishName: TextView = itemView.findViewById(R.id.dishName)
        val dishPrice: TextView = itemView.findViewById(R.id.dishPrice)
        val dishQuantity: TextView = itemView.findViewById(R.id.tvItemCount)
        val addButton: Button = itemView.findViewById(R.id.addToCartButton)
        val minusButton: Button = itemView.findViewById(R.id.btnMinus)
    }
}
