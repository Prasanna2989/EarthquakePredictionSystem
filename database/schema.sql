-- Create Location Table
CREATE TABLE IF NOT EXISTS Location (
    location_id SERIAL PRIMARY KEY,  -- Unique ID for each location
    latitude FLOAT,                  -- Latitude of the location
    longitude FLOAT,                 -- Longitude of the location
    region TEXT                      -- Name of the region
);

-- Create Earthquake Table
CREATE TABLE IF NOT EXISTS Earthquake (
    earthquake_id SERIAL PRIMARY KEY,   -- Unique ID for each earthquake
    magnitude FLOAT,                    -- Magnitude of the earthquake
    depth_km FLOAT,                     -- Depth in kilometers
    event_time TIMESTAMP,               -- Time of the earthquake
    location_id INT,                    -- Foreign key linking to Location table
    FOREIGN KEY (location_id) REFERENCES Location (location_id) ON DELETE CASCADE
);

-- Create Seismic_Station Table
CREATE TABLE IF NOT EXISTS Seismic_Station (
    station_id SERIAL PRIMARY KEY,      -- Unique ID for each seismic station
    station_name TEXT,                  -- Name of the seismic station
    location_id INT,                    -- Foreign key linking to Location table
    FOREIGN KEY (location_id) REFERENCES Location (location_id) ON DELETE CASCADE
);

-- Create Sensor_Data Table
CREATE TABLE IF NOT EXISTS Sensor_Data (
    sensor_id SERIAL PRIMARY KEY,           -- Unique ID for each sensor
    station_id INT,                         -- Foreign key linking to Seismic_Station table
    reading_time TIMESTAMP,                 -- Time of the sensor reading
    seismic_activity_level FLOAT,           -- Level of seismic activity recorded
    FOREIGN KEY (station_id) REFERENCES Seismic_Station (station_id) ON DELETE CASCADE
);

-- Create Predictions Table
CREATE TABLE IF NOT EXISTS Predictions (
    prediction_id SERIAL PRIMARY KEY,       -- Unique ID for each prediction
    earthquake_id INT,                      -- Foreign key linking to Earthquake table
    sensor_id INT,                          -- Foreign key linking to Sensor_Data table
    predicted_date TIMESTAMP,               -- Forecasted date for the earthquake
    confidence_level FLOAT,                 -- Confidence level of the prediction
    FOREIGN KEY (earthquake_id) REFERENCES Earthquake (earthquake_id) ON DELETE CASCADE,
    FOREIGN KEY (sensor_id) REFERENCES Sensor_Data (sensor_id) ON DELETE CASCADE
);
