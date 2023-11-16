package com.example.mycompose.navigation.presentation.screenC

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.mycompose.navigation.presentation.routes.ScreenRoutes

@Composable
fun ScreenC(onNavigation: (String) -> Unit, id: String?, screenCViewModel: ScreenCViewModel) {

    val input: String by screenCViewModel.input.observeAsState(initial = "")
    val showDialog: Boolean by screenCViewModel.showDialog.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                modifier = Modifier.clickable { onNavigation(ScreenRoutes.A.address) },
                text = "Screen C, " +
                        "click here to go to Screen A",
                color = Color.White, fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            id?.let {
                Text(
                    text = "Este es el id que me has pasado desde el screen B: $id",
                    color = Color.White,
                    fontSize = 30.sp
                )
            }
        }

        Divider(thickness = 5.dp)

        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            TextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Yellow,
                    cursorColor = Color.White,
                    textColor = Color.White,
                    unfocusedBorderColor = Color.White),
                value = input,
                onValueChange = { screenCViewModel.onInputChanged(it) },
                placeholder = { Text(text = "Fill 5 characters", color = Color.White) })

            if (showDialog) {
                Dialog(
                    onDismissRequest = {
                        screenCViewModel.dismissDialog()
                    },
                    content = {
                        Column(Modifier.background(Color.White).padding(30.dp)) {
                            Text(text = "This is the input text: $input", fontSize = 20.sp)
                        }
                    }
                )
            }
        }
    }
}