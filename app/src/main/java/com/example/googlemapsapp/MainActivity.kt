package com.example.googlemapsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.googlemapsapp.ui.theme.GoogleMapsAppTheme
import com.example.googlemapsapp.ui.theme.compose.MapsScreen
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoogleMapsAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenA
                    ) {
                    composable<ScreenA>() {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Button(modifier = Modifier.padding(innerPadding), onClick = {
                                    navController.navigate(ScreenB(address = "1600 Pennsylvania Avenue, Washington DC"))
                                }) {
                                    Text(text = "Click here to go to maps")
                                }
                            }
                        }
                    }
                    composable<ScreenB> {
                        val args = it.toRoute<ScreenB>()
                        MapsScreen(args.address)
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

@Serializable
object ScreenA

@Serializable
data class ScreenB(
    val address: String?
)


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GoogleMapsAppTheme {
        Greeting("Android")
    }
}