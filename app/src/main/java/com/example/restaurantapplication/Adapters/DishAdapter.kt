package com.example.restaurantapplication.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapplication.R
import com.example.restaurantapplication.model.Dish

class DishAdapter(
    private val items: List<Dish>,
    private val onAddToCart: (Dish) -> Unit = {}
) : RecyclerView.Adapter<DishAdapter.DishViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent, false)
        return DishViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.addToCartButton.setOnClickListener { onAddToCart(item) }
    }

    override fun getItemCount() = items.size

    class DishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dishImage: ImageView = itemView.findViewById(R.id.dishImage)
        private val dishName: TextView = itemView.findViewById(R.id.dishName)
        private val dishPrice: TextView = itemView.findViewById(R.id.dishPrice)
        val addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)

        fun bind(dish: Dish) {
            dishImage.setImageResource(dish.quantity)
            dishName.text = dish.name
            dishPrice.text = "₹${dish.price}"
        }
    }
}
