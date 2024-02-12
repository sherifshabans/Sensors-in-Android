package com.elsharif.sensorsinandroid.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.elsharif.sensorsinandroid.domain.AccelerometerSensor
import com.elsharif.sensorsinandroid.domain.LightSensor
import com.elsharif.sensorsinandroid.domain.ProximitySensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val lightSensor: LightSensor,
    private val accelerometerSensor: AccelerometerSensor,
    private val proximitySensor: ProximitySensor
): ViewModel() {

    var isDark by mutableStateOf(false)
    var rotationX by mutableStateOf(0f)
    var rotationY by mutableStateOf(0f)
    var sensorValues by  mutableStateOf(Pair(0f, 0f))
   // var sensorValues: Pair<Float, Float> by mutableStateOf(0f to 0f)

    var distance by mutableStateOf(0F)

    init {
/*
        viewModelScope.launch {

        }*/
        lightSensor.startListening()
        lightSensor.setOnSensorValuesChangedListener { values ->
            //values is a list values[0] is X , values [1] is Y and values[2] is Z
            val lux = values[0]
            isDark = lux < 40f
        }

        accelerometerSensor.startListening()
        accelerometerSensor.setOnSensorValuesChangedListener { values->
            val x= values[0]
            val y=values[1]
            sensorValues=Pair(x,y)
        }

        proximitySensor.startListening()
        proximitySensor.setOnSensorValuesChangedListener { values->
            distance =values[0]

        }

        }

}