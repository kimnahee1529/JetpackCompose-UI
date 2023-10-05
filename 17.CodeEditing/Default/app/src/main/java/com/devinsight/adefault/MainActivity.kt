package com.devinsight.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.devinsight.adefault.ui.theme.DefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
                MyTextArea3()
            }
        }
    }
}

@Composable
fun MyTextArea1(){
    Column(){
        Text(
            text = "안녕",
            fontSize = 100.sp,
            color = Color.Red
        )
        Text(
            text = "나는",
            fontSize = 100.sp,
            color = Color.Green
        )
        Text(
            text = "누구야",
            fontSize = 100.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun MyTextArea2(){
    Column {
        MyTextFormat2("안녕", 100.sp, Color.Red)
        MyTextFormat2("나는", 100.sp, Color.Green)
        MyTextFormat2("누구야", 100.sp, Color.Gray)
    }
}

@Composable
fun MyTextFormat2(txt: String, size: TextUnit, color: Color){
    Text(
        text = txt,
        fontSize = size,
        color = color
    )

}

@Composable
fun MyTextArea3(){
    MyTextFormat3{
        Text(
            text = "안녕",
            fontSize = 100.sp,
            color = Color.Red
        )
    }
}

@Composable
fun MyTextFormat3(content: @Composable () ->Unit){
    Column {
        content()
        content()
        content()
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DefaultTheme {
        MyTextArea3()
    }
}