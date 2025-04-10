# 🌍 Earthquake Prediction System

An end-to-end data engineering and visualization project that ingests seismic data from the USGS API, stores it in a PostgreSQL database, and visualizes earthquake patterns using a JavaFX dashboard. This system is designed to support long-term earthquake prediction through structured analysis of historical and real-time data.

---

## 📦 Project Structure

EarthquakePredictionSystem/ ├── README.md # Project documentation ├── .gitignore # Git ignored files ├── database/ │ ├── schema.sql # SQL script to create DB schema │ └── sample_data.sql # Optional sample data ├── data_ingestion/ │ └── fetch_usgs_data.py # Script to ingest data from USGS ├── ui/ │ └── HelloFX.java # JavaFX dashboard starter

---

## 🧰 Tools & Technologies

| Category             | Tools/Tech                                   |
|----------------------|----------------------------------------------|
| Database             | PostgreSQL, SQL                              |
| Data Ingestion       | Python, USGS API, psycopg2                   |
| Backend / Logic      | Python                                       |
| UI / Visualization   | Java, JavaFX                                 |
| Version Control      | Git, GitHub                                  |

---

## ⚙️ Features

- 📥 **Fetch Live Earthquake Data** from USGS API  
- 🗃️ **Normalized Database Schema** designed for extensibility  
- 📈 **Data Visualization** with JavaFX (daily trends, magnitude distribution, etc.)  
- 🔍 **SQL Analysis** on historical earthquake data  
- 🧪 Supports future integration with ML prediction models  

---

## 🚀 How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/YourUsername/EarthquakePredictionSystem.git
cd EarthquakePredictionSystem
```
---
### 2. Set Up PostgreSQL Database
Ensure PostgreSQL is installed and running

---

### Create the database and run the schema script:


psql -U your_user -d your_db -f database/schema.sql

---

###(Optional) Load sample data:

psql -U your_user -d your_db -f database/sample_data.sql

---

###3. Ingest Data from USGS

cd data_ingestion
python fetch_usgs_data.py
💡 Make sure to update your PostgreSQL connection settings inside the Python script.

---

###4. Launch JavaFX UI
Open the project in Eclipse or any Java IDE

Configure the JavaFX SDK

Run HelloFX.java to start the UI dashboard

---

📊 Sample Use Cases
🕵️ Detect regions with frequent seismic activity

🔁 Track earthquakes by day, depth, and magnitude

🔔 Use sensor data (future module) for early warning insights

---

📌 Future Enhancements
Real-time data streaming and live dashboards

Deploy web-based UI (e.g., using Dash or React.js)

Integrate ML models for improved prediction accuracy

Add REST APIs for querying the system

👤 Author
Prasanna Mahesh Gunawardana
📧 pmgunawardana@gmail.com
🌐 GitHub
📍 Melbourne, Australia

📄 License
This project is licensed under the MIT License — feel free to use and modify with credit.

---
