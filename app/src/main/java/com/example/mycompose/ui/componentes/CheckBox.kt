package com.example.mycompose.ui.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun CheckBoxes() {
    var checked by remember {
        mutableStateOf(true)
    }
    val listener = { onChecked: Boolean -> checked = onChecked }
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked,
                onCheckedChange = listener,
                enabled = true
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "un textito")
        }

        var toggleState by remember {
            mutableStateOf( ToggleableState.Off)
        }

        TriStateCheckbox(state = toggleState, onClick = {
           toggleState =  when (toggleState){
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        })
    }
}

