# Types of Sensors

## 1. Physical Sensors
These are hardware components physically present on the device. Examples include accelerometers, gyroscopes, and magnetometers.

## 2. Synthetic Sensors
These are virtual or software sensors derived from one or more physical sensors. They are not physically present on the device. Examples include gravity, linear acceleration, and step detector.

## Types of Sensor Values
### 1. Raw Values
Direct values provided by the sensor without any processing. Examples include accelerometers, proximity sensors, light sensors, and barometers.

### 2. Calibrated Values
Values computed by the operating system with correction algorithms applied, such as drift compensation and noise removal. Examples include step detector, step counter, magnetometer, and gyroscope (which provide both raw and calibrated values).

### 3. Fused Values
Values derived from a combination of two or more sensors. An example is gravity and linear acceleration, which are obtained by using accelerometer and gyroscope data.

## Categorization of Sensors
### 1. Motion Sensors
Responsible for measuring forces that could induce motion in the x, y, and z axes of the device. This includes accelerometers, gravity sensors, gyroscopes, and rotational vector sensors. Most sensors in this category provide values in the x, y, and z axes, with the rotational vector sensor providing an additional scalar component.

### 2. Position Sensors
Used to determine the physical position of the device in the world's frame of reference. For example, the geomagnetic field sensor combined with the accelerometer can determine the device's position relative to the magnetic North Pole. Orientation sensors can determine the device's position in the application's frame of reference. Position sensors also provide values in the x, y, and z axes.

### 3. Environmental Sensors
Measure environmental properties such as temperature, relative humidity, light, and air pressure near the device. Unlike motion and position sensors, which provide multi-dimensional arrays of values, environmental sensors report single sensor values.
