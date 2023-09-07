package com.example.mycompose.ui.ejercicios

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun ConstraintLayoutCompose() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxBlack, boxRed, boxBlue, boxYellow, boxGreen) = createRefs()

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Black)
            .constrainAs(boxBlack) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                bottom.linkTo(boxBlack.top)
                start.linkTo(boxBlack.end)
            })

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                bottom.linkTo(boxBlack.top)
                end.linkTo(boxBlack.start)
            })

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(boxBlack.bottom)
                end.linkTo(boxBlack.start)
            })

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(boxBlack.bottom)
                start.linkTo(boxBlack.end)
            })
    }
}

@Preview
@Composable
fun Guidelines() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val startGuidline = createGuidelineFromStart(0.2f)
        val (boxBlack, boxRed) = createRefs()

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Black)
            .constrainAs(boxBlack) {
                top.linkTo(parent.top)
                start.linkTo(startGuidline)
            })

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxBlack.bottom)
                start.linkTo(startGuidline)
            })
    }
}

@Preview
@Composable
fun Barrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxBlack, boxRed, boxGreen) = createRefs()
        val barrierEnd = createEndBarrier(boxBlack, boxRed)

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Black)
            .constrainAs(boxBlack) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })

        Box(modifier = Modifier
            .size(200.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxBlack.bottom)
                start.linkTo(parent.start)
            })

        Box(modifier = Modifier
            .size(200.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                bottom.linkTo(parent.bottom)
                start.linkTo(barrierEnd)
            })
    }
}


@Preview
@Composable
fun Chain(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxBlack, boxRed, boxGreen) = createRefs()

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Black)
            .constrainAs(boxBlack) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(boxBlack.end)
            })

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(parent.top)
                start.linkTo(boxRed.end)
            })

        createHorizontalChain(boxBlack, boxRed, boxGreen, chainStyle = ChainStyle.SpreadInside)
    }
}