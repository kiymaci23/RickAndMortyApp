package com.example.rickandmortyapp.screen.home

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.core.Screen
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.ui.theme.backgroundDarkHighContrast
import com.example.rickandmortyapp.ui.theme.backgroundLight
import com.example.rickandmortyapp.ui.theme.onBackgroundLight
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel = koinViewModel<HomeVM>()
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()

    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(138.dp)
                .padding(8.dp)
        )


        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            query = text,
            onQueryChange = {
                text = it
                viewModel.filterCharacters(it)
            },
            onSearch = {
                active = false
            },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = {
                Text("search character")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search ")
            },
            trailingIcon = {
                if (active) {
                    Icon(
                        modifier = Modifier.clickable {
                            text = ""
                            viewModel.filterCharacters("")
                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = "close "
                    )
                }
            }
        )
        {

        }



        if (viewModel.errorMessage.isNotEmpty()) {
            Text(
                text = viewModel.errorMessage,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = Color.Red
            )
        } else {
            CharacterListScreen(navController = navController, viewModel = viewModel)
        }
    }




}


@Composable
fun CharacterListScreen(viewModel: HomeVM,navController:NavHostController) {


    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .width(100.dp)
            .height(50.dp)
    ) {

        items(viewModel.characterList) { character ->
            CharacterItem(character,navController)
        }
    }
}


@Composable
fun CharacterItem(character: Character,navController:NavHostController) {
    Card(
        modifier = Modifier

            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .shadow(8.dp, shape = RoundedCornerShape(8.dp), clip = false)

            .clickable {
                navController.navigate(Screen.Detail.createRoute(character.id))
            }



    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
                .background(Color.White)

        ) {
            val (image, name, status, origin) = createRefs()

            Image(
                painter = rememberImagePainter(data = character.image),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(end = 10.dp)
            )

            Text(
                text = "Name: ${character.name}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(name) {
                    top.linkTo(parent.top)
                    start.linkTo(image.end)
                }
            )

            Text(
                text = "Status: ${character.status}",
                modifier = Modifier.constrainAs(status) {
                    top.linkTo(name.bottom)
                    start.linkTo(image.end)
                }
            )

            Text(
                text = "Origin: ${character.origin}",
                modifier = Modifier.constrainAs(origin) {
                    top.linkTo(status.bottom)
                    start.linkTo(image.end)
                }
            )
        }
    }
}


