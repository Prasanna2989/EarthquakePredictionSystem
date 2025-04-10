import requests
import psycopg2

# Database Connection Details
DB_NAME = "earthquake_db"
DB_USER = ""
DB_PASSWORD = ""
DB_HOST = "localhost"
DB_PORT = "5432"

# USGS API - Last 7 Days, Magnitude ≥ 4.0
API_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2024-03-01&endtime=2024-03-27&minmagnitude=4"

# Connect to PostgreSQL
conn = psycopg2.connect(dbname=DB_NAME, user=DB_USER, password=DB_PASSWORD, host=DB_HOST, port=DB_PORT)
cursor = conn.cursor()

# Fetch earthquake data
response = requests.get(API_URL)
data = response.json()

# Insert new earthquake events
for feature in data["features"]:
    properties = feature["properties"]
    geometry = feature["geometry"]
    
    event_time = properties["time"]  # Timestamp in milliseconds
    magnitude = properties["mag"]
    place = properties["place"]
    latitude, longitude, depth = geometry["coordinates"]  # Extract lat/lon/depth
    event_time = int(event_time) / 1000  # Convert milliseconds to seconds

    # Check if location exists
    cursor.execute("""
        SELECT location_id FROM Location WHERE latitude = %s AND longitude = %s;
    """, (latitude, longitude))
    
    location_result = cursor.fetchone()
    if location_result:
        location_id = location_result[0]  # Use existing location_id
    else:
        # Insert new location
        cursor.execute("""
            INSERT INTO Location (latitude, longitude, region)
            VALUES (%s, %s, %s) RETURNING location_id;
        """, (latitude, longitude, place))
        location_id = cursor.fetchone()[0]  # Get new location_id

    # Check if earthquake already exists
    cursor.execute("""
        SELECT earthquake_id FROM Earthquake WHERE event_time = TO_TIMESTAMP(%s) AND location_id = %s;
    """, (event_time, location_id))
    
    if cursor.fetchone() is None:  # If not found, insert new earthquake
        cursor.execute("""
            INSERT INTO Earthquake (magnitude, depth_km, event_time, location_id)
            VALUES (%s, %s, TO_TIMESTAMP(%s), %s);
        """, (magnitude, depth, event_time, location_id))
        print(f"Inserted Earthquake: {place} | Mag {magnitude}")

# Commit changes and close connection
conn.commit()
cursor.close()
conn.close()

print("✅ All earthquake data updated successfully!")

