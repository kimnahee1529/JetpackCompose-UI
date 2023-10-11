package com.devinsight.adefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devinsight.adefault.ui.theme.DefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
                ColumnRowTest2()
            }
        }
    }
}

@Composable
fun ColumnRowTest1(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.Gray)
    ) {
        Text(
            text = "안녕하세요",
            color = Color.Blue,
            fontSize = 20.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "왼쪽")
            Text(text = "중앙")
            Text(text = "오른쪽")
        }
        Text(
            text = "반갑습니다",
            color = Color.Red,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ColumnRowTest2(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.Cyan)
            .border(border = BorderStroke(5.dp, color = Color.Blue)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.gwangil),
                contentDescription = "광일이사진",
                modifier = Modifier
                    .height(160.dp)
                    .width(120.dp)
                    .clip(RoundedCornerShape(35.dp))
            )
        }
            Text(
                text = "신광일",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 50.dp)
            )
            Text(
                text = "Drumer",
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 30.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "이메일",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "gwangil@gmail.com",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.Blue
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "연락처",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "010-4732-1837",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DefaultTheme {
        ColumnRowTest2()
    }
}