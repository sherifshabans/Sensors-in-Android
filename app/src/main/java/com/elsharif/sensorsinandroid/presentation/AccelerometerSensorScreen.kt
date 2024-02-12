package com.elsharif.sensorsinandroid.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentSize

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold


import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.elsharif.sensorsinandroid.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AccelerometerSensorScreen() {
 //   val viewModel = viewModel<MainViewModel>()
    val viewModel: MainViewModel = hiltViewModel()

    val sensorValues = viewModel.sensorValues

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
                    text = stringResource(id = R.string.accelerometer_name),
                    modifier = Modifier.weight(1f),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        modifier = Modifier.fillMaxSize(),

        ) {

        SensorScreen(rotationX = sensorValues.first, rotationY = sensorValues.second)
    }
}

@Composable
fun SensorScreen(rotationX: Float, rotationY: Float) {
    val density = LocalDensity.current
    val dpMultiplier = density.density

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Box(
            modifier = Modifier
                .size(200.dp)
                .background(
                    if (rotationX.toInt() == 0 && rotationY.toInt() == 0)
                    Color.Green else Color.Red
                )
                .offset {
                    IntOffset(
                        (rotationX * 3 * dpMultiplier).toInt(),
                        (rotationY * 3 * dpMultiplier).toInt()
                    )
                }
                .wrapContentSize(),
            contentAlignment = Alignment.Center,


            ) {

            Text(
                text = "Hold the screen down straight",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(4.dp),


            )
        }}
}
