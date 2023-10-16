package com.nhkim.dice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nhkim.dice.ui.theme.DiceTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceTheme {
                MyDiceApp()
            }
        }
    }
}

@Composable
fun MyDiceApp() {

    var diceNumber by remember{
        mutableStateOf(5)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(color = Color.White)
                .border(3.dp, Color.Black)
                .padding(35.dp),
            contentAlignment = Alignment.Center
        ){
            when(diceNumber){
                1 -> DiceNumberCircle1()
                2 -> DiceNumberCircle2()
                3 -> DiceNumberCircle3()
                4 -> DiceNumberCircle4()
                5 -> DiceNumberCircle5()
                6 -> DiceNumberCircle6()
            }
        }
        Button(
            onClick = {
                diceNumber = Random.nextInt(1,7)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "주사위 굴리기",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }

        Text(
            text = diceNumber.toString(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun DiceNumberCircle1(){
    Column(
        modifier = Modifier
            .size(50.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()){
            drawCircle(Color.Black, radius = size.minDimension/10)
        }
    }
}

@Composable
fun DiceNumberCircle2(){
    Row{
        DiceNumberCircle1()
        Spacer(modifier = Modifier.size(50.dp))
        DiceNumberCircle1()
    }
}
@Composable
fun DiceNumberCircle3(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            DiceNumberCircle1()
            Spacer(modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.size(50.dp))
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Spacer(modifier = Modifier.size(50.dp))
            DiceNumberCircle1()
            Spacer(modifier = Modifier.size(50.dp))
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Spacer(modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.size(50.dp))
            DiceNumberCircle1()
        }
    }
}
@Composable
fun DiceNumberCircle4(){
    Column(
    ) {
        Row(){
            DiceNumberCircle1()
            Spacer(modifier = Modifier.size(50.dp))
            DiceNumberCircle1()
        }
        Spacer(modifier = Modifier.size(50.dp))
        Row(){
            DiceNumberCircle1()
            Spacer(modifier = Modifier.size(50.dp))
            DiceNumberCircle1()
        }
    }
}
@Composable
fun DiceNumberCircle5(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        ,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DiceNumberCircle2()
        DiceNumberCircle1()
        DiceNumberCircle2()

    }
}
@Composable
fun DiceNumberCircle6(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DiceNumberCircle2()
        DiceNumberCircle2()
        DiceNumberCircle2()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceTheme {
        MyDiceApp()
    }
}