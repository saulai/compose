package com.example.mycompose.ui.componentes

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
@Preview
fun AlertDialogs() {
    var show by remember {
        mutableStateOf(true)
    }
    if (show) {
        AlertDialog(
            title = { Text(text = "Alert Dialog") },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ),
            onDismissRequest = {
                show = false
                Log.d("DIALOG", "DIALOG DISMISSED")
            },
            confirmButton = {
                TextButton(onClick = {
                    show = false
                }) {
                    Text(text = "OLRAIT")

                }
            },
            dismissButton = {
                TextButton(onClick = {
                    show = false
                }) {
                    Text(text = "PIFIA")
                }
            }
        )
    }
}

@Composable
@Preview
fun Dialogs() {
    var show by remember {
        mutableStateOf(true)
    }
    if (show) {

        Dialog(
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ),
            onDismissRequest = {
                show = false
                Log.d("DIALOG", "DIALOG DISMISSED")
            },
            content = {
                Column(Modifier.background(Color.White)) {
                    Text(text = "This is a simple dialog, everithing has to be implemented unlike the AlertDialog")
                }
            }
        )
    }
}
