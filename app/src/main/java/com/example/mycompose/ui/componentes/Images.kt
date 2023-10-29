package com.example.mycompose.ui.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.R

@Preview
@Composable
fun Images() {
    Column() {

        Icon(imageVector = Icons.Rounded.Star, contentDescription = "Icon", tint = Color.Blue)

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Image",
            modifier = Modifier
                .clip(shape = CircleShape)
                .border(5.dp, Color.Yellow, CircleShape)
        )
    }
}