package com.example.coffeeapi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapi.domain.model.Coffee
import com.example.coffeeapi.domain.model.repository.CoffeeRepo
import com.example.coffeeapi.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: CoffeeRepo
): ViewModel() {
     private val _coffeeList: MutableStateFlow<Resource<Coffee>> =
         MutableStateFlow(Resource.Loading())
    val coffeeList: StateFlow<Resource<Coffee>> = _coffeeList

    init{
        getCoffeeList()
    }
    private fun getCoffeeList() = viewModelScope.launch {
        repo.getCoffeeList().collectLatest { _coffeeList.emit(it) }

    }
    fun getCoffeeById(id: Int) =
        _coffeeList.value.data?.id

}

