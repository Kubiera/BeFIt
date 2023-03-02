package com.example.befit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val foodItems = mutableListOf<FoodItem>()
    private lateinit var foodRecyclerView: RecyclerView
    private lateinit var addItemButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addItemButton = findViewById(R.id.newItem)
        foodRecyclerView = findViewById(R.id.items)
        val foodAdapter = FoodAdapter(this, foodItems)
        foodRecyclerView.adapter =foodAdapter
        foodRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            foodRecyclerView.addItemDecoration(dividerItemDecoration)
        }

        lifecycleScope.launch {
            (application as FoodApplication).db.foodItemDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    FoodItem(
                        entity.name,
                        entity.calories
                    )
                }.also { mappedList ->
                    foodItems.clear()
                    foodItems.addAll(mappedList)
                    foodAdapter.notifyDataSetChanged()
                }
            }
        }




        addItemButton.setOnClickListener {
            val intent = Intent(this, AddItem::class.java)
            startActivity(intent)
        }
    }
}