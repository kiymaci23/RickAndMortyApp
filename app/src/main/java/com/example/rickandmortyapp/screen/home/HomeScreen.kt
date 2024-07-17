package com.example.rickandmortyapp.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.rickandmortyapp.core.Screen
import com.example.rickandmortyapp.data.model.Character
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavHostController,) {
    val viewModel = koinViewModel<HomeVM>()

    Button(onClick = { navController.navigate(Screen.Detail.createRoute(1)) }) {
        Text(text = "Open Detail")
    }



}
@Composable
fun CharacterListScreen(viewModel: HomeVM = koinViewModel()) {


    LazyColumn {
        items(viewModel.characterList) { character ->
            CharacterItem(character)
        }
    }
}
@Composable
fun CharacterItem(character: Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {Image(
            painter = rememberImagePainter(data = character.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp))
            Text(text = "id: ${character.id}")
            Text(text = "Name: ${character.name}")
            Text(text = "Status: ${character.status}")
            Text(text = "Species: ${character.species}")
            Text(text = "type: ${character.type}")
            Text(text = "gender: ${character.gender}")
            Text(text = "origin: ${character.origin}")
            Text(text = "episode: ${character.episode}")
            Text(text = "created: ${character.created}")
            Text(text = "url: ${character.url}")
            Text(text = "image: ${character.image}")


        }

    }
}




//    val name: String,
//    val status: Status,
//    val species: Species,
//    val type: String,
//    val gender: Gender,
//    val origin: Location,
//    val location: Location,
//    val image: String,
//    val episode: List<String>,
//    val url: String,
//    val created: String