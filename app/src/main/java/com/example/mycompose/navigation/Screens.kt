package com.example.mycompose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun ScreenA(onNavigation: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .clickable { onNavigation(ScreenRoutes.B.address) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen A", color = Color.White, fontSize = 30.sp)
    }
}

@Composable
fun ScreenB(onNavigation: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            //.clickable { onNavigation(ScreenRoutes.C.withId("YD") ) },//navegación con parametro
            .clickable { onNavigation(ScreenRoutes.C.address) },//navegación haciendo uso de parametro por defecto
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen B", color = Color.White, fontSize = 30.sp)
    }
}

@Composable
fun ScreenC(onNavigation: (String) -> Unit, id: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .clickable { onNavigation(ScreenRoutes.A.address) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen C", color = Color.White, fontSize = 30.sp)
        id?.let {
            Text(
                text = "Este es el id que me has pasado: $id",
                color = Color.White,
                fontSize = 30.sp
            )
        }
    }
}