package com.example.mycompose.ui.ejercicios

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
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
fun Buttons() {
    var enabled by remember {
        mutableStateOf(true)
    }
    Column() {
        Button(
            onClick = { enabled = !enabled },
            enabled = enabled
        ) {
            Text(text = "Boton normal")
        }
        OutlinedButton(
            onClick = { enabled = !enabled },
            enabled = enabled,
            modifier = Modifier.border(border = BorderStroke(5.dp, color = Color.Magenta)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.Green
            )
        ) {
            Text(text = "Boton normal")
        }
        TextButton(
            onClick = { enabled = !enabled },
            enabled = enabled
        ) {
            Text(text = "Boton normal")
        }
    }
}