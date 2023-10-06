package com.nhkim.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nhkim.adefault.ui.theme.DefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
                MyCanvas()
            }
        }
    }
}

@Composable
fun MyCanvas(){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(Color.Red)
    ){
        Canvas(modifier = Modifier.size(200.dp).align(Alignment.Center)){
            drawCircle(Color.Black, radius = size.minDimension/2)
        }
    }
//    Box(
//        modifier = Modifier
//            .width(100.dp)
//            .height(200.dp)
//            .background(Color.Green)
//    ){
//        Canvas(modifier = Modifier.fillMaxSize()){
//            drawCircle(Color.Black, radius = size.minDimension/2)
//        }
//    }

//    Box(
//        modifier = Modifier
//            .size(20.dp)
//            .background(Color.Green)
//    ){
//        Canvas(modifier = Modifier.fillMaxSize()){
//            drawCircle(Color.Black, radius = size.minDimension/10)
//        }
//    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DefaultTheme {
        MyCanvas()
    }
}