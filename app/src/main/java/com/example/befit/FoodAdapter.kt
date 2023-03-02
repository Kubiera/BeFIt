package com.example.befit

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val context: Context, private val items: List<FoodItem>) :
        RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_item, parent, false)
        Log.d("food size", items.size.toString())
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val itemName = itemView.findViewById<TextView>(R.id.itemName)
        private val calCount = itemView.findViewById<TextView>(R.id.calcount)

        fun bind(item: FoodItem){
            itemName.text = item.name
            calCount.text = item.calories
        }
    }
}