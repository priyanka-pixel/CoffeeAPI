package com.example.coffeeapi.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coffee_item")
data class Coffee(
    val description: String = "",
    @PrimaryKey
    val id: Int = 0,
    val image: String = "",
    val title: String = ""
)