package com.devinsight.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devinsight.adefault.ui.theme.DefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
                ColumnTest2()
            }
        }
    }
}

@Composable
fun ColumnTest1(){
    Text(text = "안녕하세요1")
    Text(text = "안녕하세요2")
    Text(text = "안녕하세요3")
}

@Composable
fun ColumnTest2(){
    Column(
        modifier = Modifier.padding(30.dp)
    ){
        Text(
            text = "안녕하세요1",
            fontSize = 30.sp
        )
        Text(
            text = "안녕하세요2",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Divider(
            thickness = 5.dp,
            color = Color.Red
        )
        Text(
            text = "안녕하세요3",
            fontSize = 30.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DefaultTheme {
        ColumnTest1()
    }
}