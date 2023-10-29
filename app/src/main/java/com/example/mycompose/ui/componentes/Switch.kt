package com.example.mycompose.ui.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun Switches() {
    var checked by remember {
        mutableStateOf(true)
    }
    Column() {
        Switch(
            checked = checked,
            onCheckedChange = { checked = !checked },
            enabled = true,
            colors = SwitchDefaults.colors(
                checkedThumbColor =Color.Green,
                checkedTrackColor =Color.Yellow,
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Magenta,
                disabledCheckedThumbColor = Color.Blue,
                disabledCheckedTrackColor = Color.Yellow,
                disabledUncheckedThumbColor =Color.Black,
                disabledUncheckedTrackColor = Color.Cyan

            )
        )
    }
}