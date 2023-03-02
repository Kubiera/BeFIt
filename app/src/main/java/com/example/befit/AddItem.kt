package com.example.befit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AddItem : AppCompatActivity() {
    private lateinit var submitButton : Button
    private lateinit var calCount : EditText
    private lateinit var itemName : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        submitButton = findViewById(R.id.submitButton)
        calCount = findViewById(R.id.inputCalories)
        itemName = findViewById(R.id.inputName)

        submitButton.setOnClickListener {
            lifecycleScope.launch(IO) {
                (application as FoodApplication).db.foodItemDao().insert(
                    FoodItemEntity(
                    name = itemName.text.toString(),
                    calories = calCount.text.toString()
                )
                )
            }
            finish()
        }
    }
}