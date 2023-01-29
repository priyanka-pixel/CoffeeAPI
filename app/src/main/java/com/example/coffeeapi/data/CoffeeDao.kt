package com.example.coffeeapi.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coffeeapi.domain.model.Coffee
import com.example.coffeeapi.domain.model.CoffeeX
import kotlinx.coroutines.flow.Flow
@Dao
interface CoffeeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCoffee(coffee: CoffeeX)

    @Query("SELECT * FROM coffee_item")
    fun getAllCoffee(): Flow<List<Coffee>>
}