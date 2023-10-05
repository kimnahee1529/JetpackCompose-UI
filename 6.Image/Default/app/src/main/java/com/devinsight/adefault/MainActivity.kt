package com.devinsight.adefault

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.devinsight.adefault.ui.theme.DefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
                ImageTest2()
            }
        }
    }
}






@Composable
fun ImageTest(){
    Image(
        painter = painterResource(id = R.drawable.gwangil),
        contentDescription = "광일이 사진",
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun ImageTest2(){
    AsyncImage(
        model = "https://pbs.twimg.com/media/FaMLxYoacAY7t1p?format=jpg&name=medium",
        contentDescription = "광일이사진",
        modifier = Modifier.fillMaxSize()
    )
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DefaultTheme {
        ImageTest()
    }
}