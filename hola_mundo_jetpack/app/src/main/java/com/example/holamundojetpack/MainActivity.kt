package com.example.holamundojetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.holamundojetpack.ui.theme.HolaMundoJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaMundoJetpackTheme {
                Greeting(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var texto_escrito_us = remember { mutableStateOf("placeholder") }
    var saludar_a = remember { mutableStateOf("mundo") }

    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Hello ${saludar_a.value}!",
            //modifier = modifier
        )

        OutlinedTextField(
            value = texto_escrito_us.value,
            onValueChange = { texto_inroducido ->
                texto_escrito_us.value = texto_inroducido

            }
        )
        Button( onClick = {
            if( texto_escrito_us.value == ""){
                saludar_a.value = "mundo"
            }
            else{
                saludar_a.value =texto_escrito_us.value
                texto_escrito_us.value = ""
            }

        } ) {
            Text("PULSAME")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HolaMundoJetpackTheme {
        Greeting()
    }
}