package com.example.catapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catapp.ui.theme.CatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ScreenContent(navController)
                }

            }
        }
    }
}



@Composable
fun ScreenContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.weight(1f)) {
            // Content of the screen
        }
        LoginButton(navController)
    }
}
@Composable
fun LoginButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("destination") },
        modifier = Modifier
            .width(225.dp)
            .height(100.dp)
            .padding(horizontal = 15.dp, vertical = 25.dp)
    ) {
        Text("Sign Up")
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
            text = "Hello Kitty cat",
            modifier = modifier
    )
}

@Composable
fun DestinationScreen() {
    // Content of the destination screen
    Text("This is the destination screen")
}
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "main") {
        composable("main") {
            // Content of the main screen
            ScreenContent(navController)
        }
        composable("destination") {
            // Destination screen
            DestinationScreen()
        }
    }
}