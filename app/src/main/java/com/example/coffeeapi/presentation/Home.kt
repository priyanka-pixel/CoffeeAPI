package com.example.coffeeapi.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.coffeeapi.domain.model.Coffee
import com.example.coffeeapi.presentation.Components.ItemCoffeeCard
import com.example.coffeeapi.presentation.Components.TopBar

@Composable
fun Home(navController: NavHostController, coffeeList: List<Coffee>, toggleTheme: () -> Unit) {
    LazyColumn {
        item {
            TopBar(
                onToggle = {
                    toggleTheme()
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(coffeeList) {
            coffeeList.forEach {
                ItemCoffeeCard(
                    it,
                    onItemClicked = { coffee ->
                        navController.navigate("Details/${coffee.id}/${coffee.title}/${coffee.image}")
                    }
                )
            }
        }
    }
}
