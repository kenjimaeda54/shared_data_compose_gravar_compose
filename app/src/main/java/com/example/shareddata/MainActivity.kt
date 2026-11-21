package com.example.shareddata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.shareddata.features.registeruser.ui.screen.RegisterUserScreen
import com.example.shareddata.features.users.ui.screen.UsersScreen
import com.example.shareddata.ui.theme.SharedDataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SharedDataTheme {
                Scaffold(modifier = Modifier.fillMaxSize().background(
                    color = MaterialTheme.colorScheme.onSurface
                )) { innerPadding ->
                    Box(
                        modifier = Modifier.fillMaxSize().background(
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    ){
                        Box(
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            UsersScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SharedDataTheme {
        Greeting("Android")
    }
}