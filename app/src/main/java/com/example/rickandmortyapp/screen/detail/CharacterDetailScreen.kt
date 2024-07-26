package com.example.rickandmortyapp.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.rickandmortyapp.data.model.Character
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.R
import okhttp3.internal.wait

@Composable
fun CharacterDetailScreen(navController: NavHostController, id: Long?) {
    val viewModel = koinViewModel<CharacterDetailVM>()
    LaunchedEffect(id) {
        id?.let {
            viewModel.fetchCharacter(it)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go back")
        }

        CharacterDetailScreen(character = viewModel.character)
    }
}

@Composable

fun CharacterDetailScreen(character: Character?) {
    if (character == null) return

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (
            bgImage, profileImage, status, name, type, infoCard) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier

                .fillMaxWidth()
                .height(200.dp)
                .constrainAs(bgImage) {
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = character.status,
            modifier = Modifier.constrainAs(status) {
                top.linkTo(profileImage.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Image(
            painter = rememberImagePainter(data = character.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(2.dp, Color.White, CircleShape)
                .constrainAs(profileImage) {
                    top.linkTo(bgImage.bottom)
                    bottom.linkTo(bgImage.bottom)
                    start.linkTo(bgImage.start)
                    end.linkTo(bgImage.end)
                }
        )




        Text(
            text = character.name,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .background(Color.White)
                .constrainAs(name) {
                top.linkTo(status.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )


        Text(
            text = character.type,
            style = TextStyle(color = Color.Gray, fontSize = 20.sp),
            modifier = Modifier.constrainAs(type) {
                top.linkTo(status.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .background(Color.White)
                .constrainAs(infoCard) {
                    top.linkTo(name.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Column(modifier = Modifier
                .background(Color.LightGray)
                .padding(16.dp)) {
                Text(
                    text = "Informations",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Gender: ${character.gender}",
                    style = TextStyle(fontSize = 16.sp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Origin: ${character.origin}",
                    style = TextStyle(fontSize = 16.sp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Location: ${character.location}",
                    style = TextStyle(fontSize = 16.sp)
                )
            }
        }


    }
}

