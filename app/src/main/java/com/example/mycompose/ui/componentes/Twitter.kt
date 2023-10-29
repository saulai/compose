package com.example.mycompose.ui.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mycompose.R

@Composable
@Preview
fun Twitter() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {

    }
    Twit()
    Divider(color = Color.Gray, thickness = 1.dp)
}

@Composable
fun Twit() {
    Row(
        Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Avatar(
            Modifier
                .size(30.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        TwitContent()
    }
}

@Composable
fun TwitContent() {
    Column(Modifier.fillMaxWidth()) {
        TweetHeader()
        Text(text = "Lorem fistrum ese hombree por la gloria de mi madre tiene musho peligro pecador ese pedazo de jarl jarl. Mamaar ese que llega benemeritaar llevame al sircoo a wan te voy a borrar el cerito ese que llega a gramenawer ese hombree benemeritaar ese pedazo de. Hasta luego Lucas apetecan amatomaa de la pradera de la pradera torpedo no puedor. Ese pedazo de benemeritaar no puedor apetecan por la gloria de mi madre pupita caballo blanco caballo negroorl por la gloria de mi madre a peich te voy a borrar el cerito. Amatomaa llevame al sircoo torpedo hasta luego Lucas se calle ustée diodeno. ")
        Spacer(modifier = Modifier.padding(10.dp))
        Avatar(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Row(Modifier.fillMaxWidth()) {
            Messages(Modifier.weight(1f))
            Retweets(Modifier.weight(1f))
            Likes(Modifier.weight(1f))
        }
    }
}

@Composable
fun TweetHeader() {
    Row(Modifier.fillMaxWidth()) {
        Text(text = "Aris")
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "@ArisDev")
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "4h")
        Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
            Icon(painter = painterResource(id = R.drawable.ic_dots), contentDescription = "")
        }
    }
}

@Composable
fun Likes(modifier: Modifier) {
    var selected by remember {
        mutableStateOf(false)
    }
    Row(modifier = modifier, horizontalArrangement = Arrangement.End) {
        Icon(
            painter = if (selected) {
                painterResource(id = R.drawable.ic_like_filled)
            } else {
                painterResource(id = R.drawable.ic_like)
            },
            tint = if (selected) {
                Color.Red
            } else {
                Color.Black
            },
            contentDescription = "",
            modifier = Modifier.clickable { selected = !selected })
        Text(text = if (selected) "2" else "1")
    }
}

@Composable
fun Retweets(modifier: Modifier) {
    var selected by remember {
        mutableStateOf(false)
    }
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        Icon(
            painter = painterResource(id = R.drawable.ic_rt),
            tint = if (selected) {
                Color.Green
            } else {
                Color.Black
            },
            contentDescription = "",
            modifier = Modifier.clickable { selected = !selected })
        Text(text = if (selected) "2" else "1")
    }
}

@Composable
fun Messages(modifier: Modifier) {
    var selected by remember {
        mutableStateOf(false)
    }
    Row(modifier) {
        Icon(
            painter = if (selected) {
                painterResource(id = R.drawable.ic_chat_filled)
            } else {
                painterResource(id = R.drawable.ic_chat)
            },
            contentDescription = "",
            Modifier.clickable { selected = !selected })
        Text(text = if (selected) "2" else "1")
    }
}

@Composable
fun Avatar(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "",
        modifier = modifier
    )
}
