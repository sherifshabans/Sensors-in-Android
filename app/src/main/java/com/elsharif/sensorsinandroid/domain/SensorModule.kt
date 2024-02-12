package com.elsharif.sensorsinandroid.domain

import android.app.Application
import com.elsharif.sensorsinandroid.domain.AccelerometerSensor
import com.elsharif.sensorsinandroid.domain.LightSensor
import com.elsharif.sensorsinandroid.domain.ProximitySensor

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module providing dependencies related to sensors.
 */
@Module
@InstallIn(SingletonComponent::class)
object SensorModule {

    /**
     * Provides a singleton instance of AccelerometerSensor.
     * @param app The application context.
     * @return An instance of AccelerometerSensor.
     */
    @Provides
    @Singleton
    fun provideAccelerometerSensor(app: Application): AccelerometerSensor {
        return AccelerometerSensor(app)
    }

    /**
     * Provides a singleton instance of LightSensor.
     * @param app The application context.
     * @return An instance of LightSensor.
     */
    @Provides
    @Singleton
    fun provideLightSensor(app: Application): LightSensor {
        return LightSensor(app)
    }

    /**
     * Provides a singleton instance of ProximitySensor.
     * @param app The application context.
     * @return An instance of ProximitySensor.
     */
    @Provides
    @Singleton
    fun provideProximitySensor(app: Application): ProximitySensor {
        return ProximitySensor(app)
    }
}
