package com.elsharif.sensorsinandroid.domain

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor

/**
 * Light sensor implementation.
 * @param context The context in which the sensor operates.
 */
class LightSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT
)

/**
 * Accelerometer sensor implementation.
 * @param context The context in which the sensor operates.
 */
class AccelerometerSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_ACCELEROMETER,
    sensorType = Sensor.TYPE_ACCELEROMETER
)

/**
 * Proximity sensor implementation.
 * @param context The context in which the sensor operates.
 */
class ProximitySensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_PROXIMITY,
    sensorType = Sensor.TYPE_PROXIMITY
)
