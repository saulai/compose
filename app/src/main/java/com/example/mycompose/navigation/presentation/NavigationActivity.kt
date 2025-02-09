package com.example.mycompose.navigation.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycompose.navigation.presentation.routes.ScreenRoutes
import com.example.mycompose.navigation.presentation.screenC.ScreenC
import com.example.mycompose.navigation.presentation.screenC.ScreenCViewModel
import com.example.mycompose.ui.theme.MyComposeTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val onNavigation = { screen: String -> navController.navigate(screen) }
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoutes.A.address
                    ) {
                        composable(
                            route = ScreenRoutes.A.address,
                            content = { ScreenA(onNavigation) })
                        composable(
                            route = ScreenRoutes.B.address,
                            content = { ScreenB(onNavigation) })
                        composable(
                            route = ScreenRoutes.C.address,
                            arguments = listOf(
                                navArgument(
                                    name = "id",
                                    builder = { type = NavType.StringType
                                    defaultValue = "AIDI"})
                            ),
                            content = { navBackStackEntry ->
                                ScreenC(
                                    onNavigation,
                                    navBackStackEntry.arguments?.getString("id"),
                                    ScreenCViewModel()
                                )
                            })
                    }
                }
            }
        }
    }
}