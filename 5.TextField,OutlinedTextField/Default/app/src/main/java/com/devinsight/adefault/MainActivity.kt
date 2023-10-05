package com.devinsight.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.devinsight.adefault.ui.theme.DefaultTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
                myTextField3()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTextField1(){
    var textState by remember { mutableStateOf("Hello") }

    TextField(
        value = textState,
        onValueChange = {
            textState = it
        },
        label = {
            Text(text = "입력하는 공간")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTextField2(){
    var textState by remember { mutableStateOf("Hello") }

    OutlinedTextField(
        value = textState,
        onValueChange = {
            textState = it
        },
        label = {
            Text(text = "입력하는 공간")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTextField3(){
    var textState by remember { mutableStateOf("Hello") }
    var enteredText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textState,
            onValueChange = {
                textState = it
            }
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
            enteredText = textState
        }) {
            Text(text = "입력하기")
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "결과값 텍스트:${enteredText}")
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DefaultTheme {
        myTextField3()
//        myTextField2()
    }
}