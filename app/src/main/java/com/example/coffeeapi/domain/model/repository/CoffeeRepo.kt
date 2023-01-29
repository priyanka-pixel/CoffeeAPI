package com.example.coffeeapi.domain.model.repository


import com.example.coffeeapi.data.CoffeeDatabase
import com.example.coffeeapi.domain.model.Coffee
import com.example.coffeeapi.network.CoffeeAPI
import com.example.coffeeapi.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoffeeRepo @Inject constructor( private val coffeeApi: CoffeeAPI,
     private val db: CoffeeDatabase
): RepoInterface {
    override suspend fun getCoffeeList(): Flow<Resource<Coffee>> = flow {
        emit(Resource.Loading())
        try {
            val response = coffeeApi.getCoffeeList()
            if (response.isSuccessful)
                response.body()?.let { emit(Resource.Success(it)) }
            else
                emit(Resource.Error(response.code().toString()))
        } catch (E: HttpException) {
            emit(Resource.Error("Could not load data"))
        } catch (E: IOException) {
            emit(Resource.Error("Check internet"))
        }
    }
}