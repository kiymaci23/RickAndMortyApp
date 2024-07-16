package com.example.rickandmortyapp.screen.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.rickandmortyapp.core.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel = koinViewModel<HomeVM>()

    Button(onClick = { navController.navigate(Screen.Detail.createRoute(1)) }) {
        Text(text = "Open Detail")
    }
}