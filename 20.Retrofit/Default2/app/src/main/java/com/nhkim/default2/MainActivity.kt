package com.nhkim.default2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nhkim.default2.ui.theme.Default2Theme
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Default2Theme {
                InsertInputData()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun InsertInputData(){

        //입력하는 숫자
        var inputNumber by remember {
            mutableStateOf("")
        }

        //받아온 데이터 모델
        var post by remember {
            mutableStateOf<Post?>(null)
        }

        //API 통신하는 부분
        val coroutineScope = rememberCoroutineScope()

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextField(
                value = inputNumber,
                onValueChange = {inputNumber = it},
                label = { Text(text = "입력값(숫자)를 입력하세요") }
            )
            
            Button(onClick = {
                val number = inputNumber.toIntOrNull()
                if(number != null){
                    coroutineScope.launch {
                        post = getPostData(number)
                    }
                }
            }) {
                Text(text = "데이터 받아오기")
            }

            post?.let { 
                Text(text = "userId: "+it.userId)
                Text(text = "id: "+it.id)
                Text(text = "title: "+it.title)
                Text(text = "body: "+it.body)
            }

        }
    }

    private suspend fun getPostData(number: Int): Post?{
        val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)
        val response = retrofitInstance.getPostNumber(number)
        return if(response.isSuccessful) response.body() else null
    }
}

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

object RetrofitInstance {

    val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val client = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance() : Retrofit {
        return client
    }

}
interface MyApi {
    @GET("posts/1")
    suspend fun getPost1(): Response<Post>

    @GET("posts/{number}")
    suspend fun getPostNumber(
        @Path("number") number: Int
    ): Response<Post>
}