package com.sumanta.loincompose.ui.retrofit.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.sumanta.loincompose.ui.retrofit.data.Post
import com.sumanta.loincompose.ui.retrofit.util.ApiState
import com.sumanta.loincompose.ui.retrofit.viewmodel.MainViewModel
import com.sumanta.loincompose.ui.theme.LoinComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity: ComponentActivity() {
    
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            LoinComposeTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    GetData(mainViewModel = mainViewModel)
                }
            }
        }
    }
    
    @Composable
    fun EachRow(post: Post){
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(CornerSize(4.dp)),
            elevation = 2.dp
        
        ) {
            Text(text = post.body, modifier = Modifier.padding(10.dp), fontStyle = FontStyle.Italic)
            
        }
    }
    
    @Composable
    fun GetData(mainViewModel: MainViewModel){
        when(val result = mainViewModel.response.value){
            is ApiState.Success ->{
                LazyColumn{
                    items(result.data){response->
                        EachRow(post = response)
                    }
                }
            }
            is ApiState.Failure ->{
                Text(text = "${result.msg}")
            }
            
            ApiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier
                    .padding(4.dp),
                    color = Color.Yellow)
            }
            ApiState.Empty->{
                
            }
        }
    }
    
}