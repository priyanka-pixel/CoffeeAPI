package com.example.coffeeapi.domain.model.repository

import com.example.coffeeapi.domain.model.Coffee
import com.example.coffeeapi.domain.model.CoffeeX
import com.example.coffeeapi.util.Resource
import kotlinx.coroutines.flow.Flow

interface RepoInterface {

    suspend fun getCoffeeList(): Flow<Resource<Coffee>>
}