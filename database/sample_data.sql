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
