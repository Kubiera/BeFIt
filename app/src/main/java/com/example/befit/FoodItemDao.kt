package com.example.befit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodItemDao {
    @Query("SELECT * FROM foodtable")
    fun getAll(): Flow<List<FoodItemEntity>>

    @Insert
    fun insert(item: FoodItemEntity)
}