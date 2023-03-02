package com.example.befit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foodtable")
class FoodItemEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "calories") val calories: String?
    )