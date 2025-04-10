
-- Create a new database
CREATE DATABASE earthquake_db;

-- Connect to the new database
\c earthquake_db;

-- Create a user with password
CREATE USER earthquake_user WITH PASSWORD 'earthquake_password';

-- Grant all privileges to the user on the new database
GRANT ALL PRIVILEGES ON DATABASE earthquake_db TO earthquake_user;



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



-- Insert Sample Location Data
INSERT INTO Location (latitude, longitude, region) 
VALUES 
    (34.0522, -118.2437, 'California'),
    (35.6895, 139.6917, 'Tokyo'),
    (40.7128, -74.0060, 'New York');

-- Insert Sample Earthquake Data
INSERT INTO Earthquake (magnitude, depth_km, event_time, location_id)
VALUES 
    (5.6, 10.0, '2024-03-15 10:30:00', 1), -- California earthquake
    (7.1, 20.0, '2024-03-16 12:45:00', 2), -- Tokyo earthquake
    (6.0, 15.0, '2024-03-17 14:00:00', 3); -- New York earthquake

-- Insert Sample Seismic Station Data
INSERT INTO Seismic_Station (station_name, location_id)
VALUES 
    ('Station A', 1),
    ('Station B', 2),
    ('Station C', 3);

-- Insert Sample Sensor Data
INSERT INTO Sensor_Data (station_id, reading_time, seismic_activity_level)
VALUES 
    (1, '2024-03-15 10:31:00', 8.1),
    (2, '2024-03-16 12:46:00', 7.5),
    (3, '2024-03-17 14:01:00', 6.3);

-- Insert Sample Predictions Data
INSERT INTO Predictions (earthquake_id, sensor_id, predicted_date, confidence_level)
VALUES 
    (1, 1, '2024-03-20', 0.85),
    (2, 2, '2024-03-25', 0.90),
    (3, 3, '2024-03-28', 0.80);

