package com.nhkim.graph.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nhkim.graph.GraphAppMain
import com.nhkim.graph.ui.theme.GraphTheme

@Composable
fun Graph1(){
    Box(
        modifier = Modifier.padding(top = 130.dp)
    ){
        GraphGauge(70f,100f)
    }
}

@Composable
fun GraphGauge(percent: Float, maxPercent: Float){
    val colorPercent = 360 * (percent / maxPercent)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(20.dp)
    ){
        Canvas(modifier = Modifier.fillMaxSize()){
            drawArc(
                color = Color.LightGray,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = true,
                style = Stroke(20f)
            )
            drawArc(
                color = Color.Blue,
                startAngle = -90f,
                sweepAngle = colorPercent,
                useCenter = false,
                style = Stroke(20f)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = percent.toInt().toString(),
                fontSize = 35.sp
            )
            Text(text = "${percent} / ${maxPercent}",
                fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GraphGaugePreview() {
    GraphTheme {
        GraphGauge(70f,100f)
    }
}