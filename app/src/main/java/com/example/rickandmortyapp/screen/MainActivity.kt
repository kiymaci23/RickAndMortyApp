package com.example.rickandmortyapp.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapp.core.BaseActivity
import com.example.rickandmortyapp.core.Navigation
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {
    private val viewModel: MainActivityVM by inject()




    @Composable
    override fun Content() {
        super.Content()
        InitNavHost()
    }

    @Composable
    fun InitNavHost() {
        val navController = rememberNavController()
        Navigation(navController = navController)
    }
}

