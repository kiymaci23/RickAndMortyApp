package com.example.rickandmortyapp.screen.detail

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterDetailScreen(navController: NavHostController, id: Int?) {
    val viewModel = koinViewModel<CharacterDetailVM>()

    Button(onClick = { navController.popBackStack() }) {
        Text(text = "Go back $id")
    }
}