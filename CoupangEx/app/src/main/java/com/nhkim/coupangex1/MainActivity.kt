package com.nhkim.coupangex1

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
import androidx.compose.ui.tooling.preview.Preview
import com.nhkim.coupangex1.ui.theme.CoupangEx1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface() {
                Column {
                    TopLogoArea()
                    TopSearchBarArea()
                    TopBanner()
                    CategoryList()
                    CenterBannerArea()
                }
            }
        }
    }
}

@Composable
fun TopLogoArea() {
    
}

@Composable
fun TopSearchBarArea() {
    
}

@Composable
fun TopBanner() {
    
}

@Composable
fun CategoryList() {
    
}

@Composable
fun CenterBannerArea() {
    
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoupangEx1Theme {
        
    }
}