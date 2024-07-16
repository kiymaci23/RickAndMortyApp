package com.example.rickandmortyapp.screen

import android.graphics.Path
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmortyapp.ui.theme.RickandmortyappTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            RickandmortyappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    SetupNavigator(navController = navController)



                    viewModel.getCharacters()
                }
            }
        }
    }

    @Composable
    private fun SetupNavigator(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "screen1") {
            composable("screen1") { Screen1(navController) }
            composable(
                route = "screen2/{name}",
                arguments = listOf(navArgument("name") { type = NavType.StringType })
            ) { backStackEntry ->
                Screen2(
                    navController,
                    name = backStackEntry.arguments?.getString("name") ?: ""
                )
            }
        }

    }

    @Composable
    private fun Screen1(navController: NavHostController) {

        LazyColumn(  modifier = Modifier.fillMaxSize() ,
            verticalArrangement = Arrangement.Top){


        }
        Greeting("Screen1 Android")
        Button(onClick = { navController.navigate("screen2/Gokturk") }) {

        }

    }

}

@Composable
private fun Screen2(navController: NavHostController, name: String = "berkay") {
    Greeting(name)

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickandmortyappTheme {
        Greeting("Android")
    }

}
