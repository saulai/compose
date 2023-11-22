package com.example.mycompose.ui.componentes

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun Animations() {
    var firstColor by rememberSaveable {
        mutableStateOf(true)
    }
    val colorAnimated by animateColorAsState(
        targetValue = if (firstColor) {
            Color.Yellow
        } else {
            Color.Blue
        },
        animationSpec = tween(1000),
        finishedListener = {},
        label = ""
    )
    Column {
        OutlinedButton(
            onClick = { firstColor = !firstColor },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorAnimated,
                contentColor = Color.Green
            )
        ) {
            Text(text = "Color animation")
        }

        var firstSize by rememberSaveable {
            mutableStateOf(true)
        }
        val sizeAnimated by animateDpAsState(
            targetValue = if (firstSize) {
                30.dp
            } else {
                80.dp
            },
            finishedListener = {},
            animationSpec = tween(500), label = ""
        )

        TextButton(
            onClick = { firstSize = !firstSize },
        ) {
            Text(text = "Size animation",  modifier = Modifier.height(sizeAnimated).background(Color.LightGray))
        }
    }
}