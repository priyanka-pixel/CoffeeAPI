package com.example.coffeeapi.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coffeeapi.domain.model.Coffee

@Database(entities = [Coffee::class], version = 1, exportSchema = false)
     abstract class CoffeeDatabase : RoomDatabase() {
             abstract fun getDao(): CoffeeDao
}