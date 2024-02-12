package com.elsharif.sensorsinandroid

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.getSystemService
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elsharif.sensorsinandroid.presentation.AccelerometerSensorScreen
import com.elsharif.sensorsinandroid.presentation.HomeScreen
import com.elsharif.sensorsinandroid.presentation.LightSensorScreen
import com.elsharif.sensorsinandroid.presentation.ProximitySensorScreen
import com.elsharif.sensorsinandroid.ui.theme.SensorsInAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensorsInAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){



                    val context= LocalContext.current




                    // Set up the Navigation host
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        HomeScreen(navController)
                    }
                    composable("LightSensor") {
                        LightSensorScreen()
                    }
                    composable("AccelerometerSensor") {
                        AccelerometerSensorScreen()
                    }
                    composable("ProximitySensor") {
                        ProximitySensorScreen(context)
                    }

                }
                }

            }
        }
    }
}

