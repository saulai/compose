package com.example.mycompose.ui.ejercicios

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun ProgressBar(){
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Row(Modifier.fillMaxWidth()) {
            CircularProgressIndicator(strokeWidth = 5.dp, color = Color.Black)
            LinearProgressIndicator(backgroundColor = Color.Green, color = Color.Blue)
        }
        var progress by remember {
            mutableStateOf(0f)
        }
        Row {
            CircularProgressIndicator(progress = progress)
            LinearProgressIndicator(progress = progress)
        }
        Button(onClick = { progress += 0.1f }) {
            Text(text = "increase progress")
        }
    }
}