package com.example.mycompose.ui.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun TextFields() {
    Column {
        Text(
            text = "Texto",
            style = TextStyle(
                color = Color.Red,
                fontFamily = FontFamily.Monospace,
                textDecoration = TextDecoration.Underline
            )
        )

        var myText by remember { mutableStateOf("") }
        TextField(value = myText, onValueChange = { myText = it.replace("a", "Á") },
            label = { Text(text = "Esto es un hint") })

        OutlinedTextField(
            value = myText, onValueChange = { myText = it },
            modifier = Modifier.padding(24.dp),
            label = { Text(text = "Esto es un hint") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                cursorColor = Color.Red,
                unfocusedBorderColor = Color.Cyan
            )
        )
    }
}