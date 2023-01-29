package com.example.coffeeapi.network

import com.example.coffeeapi.domain.model.Coffee
import com.example.coffeeapi.domain.model.CoffeeX
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CoffeeAPI {
    @GET("/coffee/hot/")
    suspend fun getCoffeeList(): List<Coffee>

   @GET("/coffee/hot/{id}")
   suspend fun getCoffeeById(@Path("id") id: Int): List<Coffee>


   companion object {
        const val BASE_URL = "https://api.sampleapis.com"
}
}