package com.example.mycompose.navigation

sealed class ScreenRoutes(val address: String) {
    object A: ScreenRoutes("A")
    object B: ScreenRoutes("B")
    object C: ScreenRoutes("C?id={id}"){
        fun withId(id: String) = "C?id=$id"
    }
}