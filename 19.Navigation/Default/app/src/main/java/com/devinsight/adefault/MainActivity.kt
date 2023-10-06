package com.devinsight.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devinsight.adefault.ui.theme.DefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
                MyNav()
            }
        }
    }
}

@Composable
fun myScreen1(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "1번 화면",
            fontSize = 20.sp
        )
        Button(onClick = {
            navController.navigate("myScreen2")
        }) {
            Text(text = "2번 화면으로 가기")
        }
    }
}

@Composable
fun myScreen2(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "2번 화면",
            fontSize = 20.sp
        )
        Button(onClick = {
            navController.navigate("myScreen3")
        }){
        Text(text = "3번 화면으로 가기")
        }
    }
}

@Composable
fun myScreen3(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "3번 화면",
            fontSize = 20.sp
        )
        Button(onClick = {
            navController.navigate("myScreen1")
        })  {
            Text(text = "1번 화면으로 가기")
        }
    }
}

@Composable
fun MyNav(){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "myScreen2"){
        composable("myScreen1"){
            myScreen1(navController = navController)
        }
        composable("myScreen2"){
            myScreen2(navController = navController)
        }
        composable("myScreen3"){
            myScreen3(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DefaultTheme {
        MyNav()
    }
}