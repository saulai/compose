package com.example.mycompose.ui.componentes

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.R
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(onTopBarClick = { elementoPulsado: String ->
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("has pulsado $elementoPulsado")
                }
            },
                openDrawer = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        bottomBar = { MyBottomBar() },
        floatingActionButton = { MyFloatingActionButton() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        drawerContent = {
            MyDrawer {
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        }
    ) {}
}

@Composable
fun MyDrawer(closeDrawer: () -> Unit) {
    Column {
        Text(text = "Opcion A", fontSize = 30.sp, modifier = Modifier.clickable { closeDrawer() })
        Text(text = "Opcion B", fontSize = 30.sp, modifier = Modifier.clickable { closeDrawer() })
        Text(text = "Opcion C", fontSize = 30.sp, modifier = Modifier.clickable { closeDrawer() })
    }
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(painter = painterResource(id = R.drawable.ic_like), contentDescription = "")
    }
}

@Composable
fun MyBottomBar() {
    BottomNavigation {
        BottomNavigationItem(selected = false, onClick = { }, icon = {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_rt
                ),
                contentDescription = ""
            )
        })
        BottomNavigationItem(selected = false, onClick = { }, icon = {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_like
                ),
                contentDescription = ""
            )
        })
        BottomNavigationItem(selected = false, onClick = { }, icon = {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_chat
                ),
                contentDescription = ""
            )
        })
    }
}

@Composable
fun TopBar(onTopBarClick: (String) -> Unit, openDrawer: () -> Unit) {
    TopAppBar(title = { Text(text = "Top bar con actions y navigation") }, elevation = 20.dp,
        navigationIcon = {
            IconButton(onClick = { openDrawer() }) {
                Icon(painter = painterResource(id = R.drawable.ic_like), contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { onTopBarClick("chat") }) {
                Icon(painter = painterResource(id = R.drawable.ic_chat), contentDescription = "")
            }
            IconButton(onClick = { onTopBarClick("tweet") }) {
                Icon(painter = painterResource(id = R.drawable.ic_rt), contentDescription = "")
            }
        })
}
