package com.example.mycompose.ui.componentes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.R
import kotlinx.coroutines.launch

@Composable
@Preview
fun HorizontalList() {
    Column() {
        Text(text = "Lazy row", modifier = Modifier.fillMaxWidth(), color = Color.Red)
        LazyRow(
            contentPadding = PaddingValues(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp) //ESPACIADO DE ELEMENTOS
        ) {
            item {
                Text(text = "List header", color = Color.Green)

            }
            items(getItems()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Blue, shape = RectangleShape)
                ) {
                    Icon(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.ic_rt),
                        contentDescription = ""
                    )
                    Text(text = it.nombre)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun VerticalList() {
    val lazyListState =
        rememberLazyListState()//CONTROLA EL ESTADO DEL LISTADO Y ME DA INFORMACION UTIL EN LOS REPINTADOS. ULTIMO INDEX EN PANTALLA ETC
    val coroutineScope = rememberCoroutineScope()
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Lazy column", modifier = Modifier.fillMaxWidth(), color = Color.Red)
        LazyColumn(
            state = lazyListState,
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            getItems().groupBy { it.genero }.forEach { (genero, personas) ->
                stickyHeader {//HEADER STICKY POR SECCIONES
                    Row(
                        modifier = Modifier
                            .background(color = Color.Gray)
                            .fillMaxWidth(),
                        horizontalArrangement = Center
                    ) {
                        Text(text = genero, color = Color.Green, fontSize = 30.sp)
                    }
                }
                items(personas) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(Color.Gray, shape = RectangleShape)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(200.dp),
                            painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = ""
                        )
                        Text(text = it.nombre, fontSize = 20.sp)
                    }
                }
            }
        }

        val showButton by remember {
            derivedStateOf {
                lazyListState.firstVisibleItemIndex > 0
            }
        }

        if (showButton) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        lazyListState.animateScrollToItem(0)
                    }
                },
                enabled = true
            ) {
                Text(text = "Volver arriba")
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun GridList() {
  val coroutineScope = rememberCoroutineScope()
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Vertical Grid", modifier = Modifier.fillMaxWidth(), color = Color.Red)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(10.dp)
        ) {
            getItems().groupBy { it.genero }.forEach { (_, personas) ->
                items(personas) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(Color.Gray, shape = RectangleShape)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(100.dp),
                            painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = ""
                        )
                        Text(text = it.nombre, fontSize = 20.sp)
                    }
                }
            }
        }
    }
}

fun getItems() =
    listOf(
        Persona("Mary", "mujer"),
        Persona("Joselin"),
        Persona("Pepe", "hombre"),
        Persona("Rui", "hombre"),
        Persona("Lucia", "mujer"),
        Persona("Antonio", "hombre"),
        Persona("Rosa", "mujer"),
        Persona("XYZ"),
        Persona("Maria"),
        Persona("Luis"),
        Persona("Amanda"),
        Persona("Romualdo", "hombre")
    )

data class Persona(
    val nombre: String,
    val genero: String = "No binario"
)