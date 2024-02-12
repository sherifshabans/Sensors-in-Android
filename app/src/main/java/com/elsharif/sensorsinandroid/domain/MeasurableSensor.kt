package com.elsharif.sensorsinandroid.domain

/**
 * Abstract class representing a sensor with measurable values in the Android system.
 * @param sensorType The type of the sensor as per Android Sensor types.
 */
abstract class MeasurableSensor(
    // The type of the sensor.
    protected val sensorType: Int
) {

    // Callback to be triggered when sensor values change.
    protected var onSensorValuesChanged: ((List<Float>) -> Unit)? = null

    /**
     * Indicates whether the sensor exists on the device.
     */
    abstract val doesSensorExist: Boolean

    /**
     * Starts listening to sensor events.
     */
    abstract fun startListening()

    /**
     * Stops listening to sensor events.
     */
    abstract fun stopListening()

    /**
     * Sets the listener for sensor value changes.
     * @param listener The listener function to be invoked when sensor values change.
     */
    fun setOnSensorValuesChangedListener(listener: (List<Float>) -> Unit) {
        onSensorValuesChanged = listener
    }
}
