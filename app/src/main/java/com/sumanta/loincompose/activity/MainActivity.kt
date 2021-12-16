package com.sumanta.loincompose.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sumanta.loincompose.ui.theme.LoinComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoinComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen()
                }
            }
        }
    }
}

 fun logged(username: String, password: String){
    if (username == "Sumanta" && password == "123"){
        //Toast.makeText(this,"", Toast.LENGTH_SHORT).show()
    }else{
       // Toast.makeText(this,"",Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun LoginScreen() {
    val userName = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
        ) {
        Text(
            text = "Hello Again!",
            color = Color.Blue,
            fontSize = 25.sp, fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Welcome",
            color = Color.Blue,
            fontSize = 25.sp, fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Back",
            color = Color.Blue,
            fontSize = 25.sp, fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = userName.value,
            onValueChange = {userName.value = it
            },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription ="Person")
            },
            label = {
                Text(text = "UserName")
            },
            placeholder = {
                Text(text = "enter username")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = {password.value = it
            },
            leadingIcon = {
                Icon(Icons.Default.Info, contentDescription ="Person")
            },
            label = {
                Text(text = "Password")
            },
            placeholder = {
                Text(text = "enter password")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedButton(onClick = { logged(userName.value, password.value) },
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
        ) {
            Text(text = "Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoinComposeTheme {
        LoginScreen()
    }
}