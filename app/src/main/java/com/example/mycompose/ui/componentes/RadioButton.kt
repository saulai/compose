package com.example.mycompose.ui.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun RadioButtons() {
    var selectedA by remember {
        mutableStateOf(false)
    }
    var selectedB by remember {
        mutableStateOf(false)
    }
    Column() {
        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                onClick = {
                    if (!selectedA) {
                        selectedA = true
                        selectedB = false
                    }
                },
                selected = selectedA
            )
            Text(text = "Opcion A")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                onClick = {
                    if (!selectedB) {
                        selectedB = true
                        selectedA = false
                    }
                },
                selected = selectedB
            )
            Text(text = "Opcion B")
        }

    }

}

