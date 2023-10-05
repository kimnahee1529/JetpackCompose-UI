package com.devinsight.adefault

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.devinsight.adefault.ui.theme.DefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
//                MyWebView("https://www.daum.net/")
                 MyWebView("https://www.naver.com/")
//                MyWebView("https://www.youtube.com/")
            }
        }
    }
}

@Composable
fun MyWebView(url: String){
    AndroidView(factory = {
        WebView(it).apply {
            loadUrl(url)
        }
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DefaultTheme {

    }
}