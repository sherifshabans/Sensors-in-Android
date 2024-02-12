package com.elsharif.sensorsinandroid.domain

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

/**
 * Abstract class representing a sensor in the Android system.
 * @param context The context in which the sensor operates.
 * @param sensorFeature The feature string to check whether the sensor is available on the device.
 * @param sensorType The type of the sensor as per Android Sensor types.
 */
abstract class AndroidSensor(
    private val context: Context,
    private val sensorFeature: String,
    sensorType: Int
): MeasurableSensor(sensorType), SensorEventListener {

    // Indicates whether the sensor exists on the device.
    override val doesSensorExist: Boolean
        get() = context.packageManager.hasSystemFeature(sensorFeature)

    // The sensor manager responsible for handling sensor operations.
    private lateinit var sensorManager: SensorManager

    // The specific hardware sensor instance.
    private var sensor: Sensor? = null

    /**
     * Starts listening to sensor events.
     */
    override fun startListening() {
        if(!doesSensorExist) {
            return
        }
        if(!::sensorManager.isInitialized && sensor == null) {
            sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
            sensor = sensorManager.getDefaultSensor(sensorType)
        }
        sensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    /**
     * Stops listening to sensor events.
     */
    override fun stopListening() {
        if(!doesSensorExist || !::sensorManager.isInitialized) {
            return
        }
        sensorManager.unregisterListener(this)
    }

    /**
     * Callback method triggered when sensor values change.
     * @param event The sensor event containing the new sensor values.
     */
    override fun onSensorChanged(event: SensorEvent?) {
        if(!doesSensorExist) {
            return
        }
        if(event?.sensor?.type == sensorType) {
            onSensorValuesChanged?.invoke(event.values.toList())
        }
    }

    /**
     * Callback method triggered when sensor accuracy changes.
     * @param sensor The sensor whose accuracy changed.
     * @param accuracy The new accuracy value.
     */

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) = Unit
}

