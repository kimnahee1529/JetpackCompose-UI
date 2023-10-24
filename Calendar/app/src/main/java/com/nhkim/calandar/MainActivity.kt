package com.nhkim.calandar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nhkim.calandar.ui.theme.CalandarTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalandarTheme {
                CalandarApp()
            }
        }
    }
}

@Composable
fun CalandarApp(){
    //시간에 대한 정보
    val calandarInstance = Calendar.getInstance()
    val time = remember{
        mutableStateOf(calandarInstance
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CalendarHeader(time)
        CalendarHeaderBtn(time)
        CalendarDayName()
        CalendarDayList(time)
    }

}

@Composable
fun CalendarHeader(date: MutableState<Calendar>) {
    //xxxx년 00월
    val resultTime = SimpleDateFormat("YYYY년 MM월", Locale.KOREA).format(date.value.time)

    Text(
        text = resultTime,
        fontSize = 30.sp
    )
}

@Composable
fun CalendarHeaderBtn(date: MutableState<Calendar>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
                val newDate = Calendar.getInstance()
                newDate.time = date.value.time
                newDate.add(Calendar.MONTH, -1)
                date.value = newDate
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text(
                text = "<",
                fontSize = 20.sp
            )
        }
        Button(
            onClick = {
                val newDate = Calendar.getInstance()
                newDate.time = date.value.time
                newDate.add(Calendar.MONTH, +1)
                date.value = newDate },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text(
                text = ">",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun CalendarDayName() {
    val nameList = listOf("일", "월", "화", "수", "목", "금", "토")

    Row(

    ){
        nameList.forEach{
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = it,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

@Composable
fun CalendarDayList(date: MutableState<Calendar>) {

    //달력 그리는 공식

    date.value.set(Calendar.DAY_OF_MONTH, 1)
    val monthDayMax = date.value.getActualMaximum(Calendar.DAY_OF_MONTH) //현재 달의 max
    val monthFirstDay = date.value.get(Calendar.DAY_OF_WEEK) - 1 // 1일이 무슨 요일부터인지
    val monthWeeksCount = (monthDayMax + monthFirstDay + 6 ) / 7 // 현재 달의 week 갯수

    Column() {
        repeat(monthWeeksCount){ week->
            Row {
                repeat(7){ day ->
                    val resultDay = week * 7 + day - monthFirstDay + 1

                    if(resultDay in 1 .. monthDayMax){
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = resultDay.toString(),
                                fontSize = 25.sp
                            )
                        }
                    } else{
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalandarTheme {
        CalandarApp()
    }
}