package com.elsharif.sensorsinandroid.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.res.stringResource
import com.elsharif.sensorsinandroid.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController:NavController) {

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    modifier = Modifier.weight(1f),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        modifier = Modifier.fillMaxSize(),

    ) {

        val buttonList = listOf("AccelerometerSensor", "LightSensor","ProximitySensor")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),

            ) {
   LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = Modifier
            .fillMaxWidth()
            .padding(it),
        verticalArrangement = Arrangement.spacedBy(30.dp),
    ) {
        items(buttonList) { buttonText ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Button(
                    onClick = {
                        buttonClickTf(navController, buttonText)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),

                    colors = ButtonDefaults.buttonColors(Color(0xFFBDA728)) // Set the text color here

                ) {
                    Text(text = buttonText,
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold

                    )
                }
            }
        }
     }
   }
  }
 }
private fun buttonClickTf(
    navController:NavController,
    buttonText: String,
) {
    when (buttonText) {
        "AccelerometerSensor", "LightSensor","ProximitySensor"  -> {
            navController.navigate(buttonText)
        }
    }
}
