package com.example.rickandmortyapp.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapp.ui.theme.RickandmortyappTheme


open class BaseActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController

    @Composable
    open fun Content() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navHostController = rememberNavController()
            RickandmortyappTheme {
                Box(Modifier.fillMaxSize()) {
                    Content()
                }
            }
        }
    }
}
