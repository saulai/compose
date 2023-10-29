package com.example.mycompose.ui.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BadgedBox
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun Cards() {
    Column(
        Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = MaterialTheme.shapes.medium,
            backgroundColor = Color.Yellow,
            contentColor = Color.Red,
            border = BorderStroke(width = 2.dp, color = Color.Blue),
            elevation = 12.dp

        ) {
            Column(Modifier.padding(10.dp)) {
                Text(text = "text 1")
                Text(text = "text 1")
                Text(text = "text 1")
                Text(text = "text 1")
            }
        }

        BadgedBox(
            badge = { Text(text = "5", Modifier.background(Color.Red, shape = CircleShape)) },
            Modifier.padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = "")
        }

        Divider(
            Modifier
                .fillMaxWidth()
                .padding(5.dp), color = Color.DarkGray
        )

        var selectedText by rememberSaveable {
            mutableStateOf("")
        }
        var expanded by rememberSaveable {
            mutableStateOf(true)
        }
        val menuItems = listOf("A", "B", "C")

        Button(onClick = { expanded = true }) {
            Text(text = "expand")
        }
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            readOnly = true,
            modifier = Modifier
                .clickable {
                    expanded = true
                }
                .fillMaxWidth(),
        )

        //TODO ARREGLAR EL EVENTO DE CLICK DEL EDITTEXT
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            menuItems.forEach {
                DropdownMenuItem(onClick = {
                    selectedText = it
                    expanded = false
                }) {
                    Text(text = it)
                }
            }
        }
        var sliderValue by rememberSaveable {
            mutableFloatStateOf(0f)
        }
        var textValue by rememberSaveable {
            mutableStateOf("")
        }
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            onValueChangeFinished = { textValue = sliderValue.toString()},
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = textValue)

        var rangeValue by remember {
            mutableStateOf(2f..4f)
        }
        var textRangeValue by rememberSaveable {
            mutableStateOf("")
        }

        RangeSlider(
            value = rangeValue,
            onValueChange = {rangeValue = it},
            enabled = false,
            valueRange = 0f..10f,
            steps = 9,
            onValueChangeFinished = { textRangeValue = rangeValue.toString()},
        )
        Text(text = textRangeValue)

    }


}

