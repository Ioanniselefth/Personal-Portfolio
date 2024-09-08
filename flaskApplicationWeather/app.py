import requests
import sqlite3
from datetime import datetime, timedelta
from flask import Flask, jsonify, render_template, g, request

app = Flask(__name__)

API_USERNAME = "amdocs_eleftheriadis_ioannis"  
API_PASSWORD = "6uyJCYu00I" 
METEOMATICS_API_BASE = "https://api.meteomatics.com"

locations = [
    {"name": "Berlin", "lat": 52.52, "lon": 13.4050},
    {"name": "New York", "lat": 40.7128, "lon": -74.0060},
    {"name": "Tokyo", "lat": 35.6762, "lon": 139.6503},
]

def get_db_connection():
    if 'db' not in g:
        g.db = sqlite3.connect('weather_data.db', timeout=10)
        g.db.row_factory = sqlite3.Row
    return g.db

@app.teardown_appcontext
def close_db_connection(exception):
    db = g.pop('db', None)
    if db is not None:
        db.close()

def init_db():
    conn = get_db_connection()
    cursor = conn.cursor()

    cursor.execute('''
        CREATE TABLE IF NOT EXISTS locations (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            latitude REAL NOT NULL,
            longitude REAL NOT NULL
        )
    ''')

    cursor.execute('''
        CREATE TABLE IF NOT EXISTS forecasts (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            location_id INTEGER,
            date TEXT NOT NULL,
            temp REAL NOT NULL,
            FOREIGN KEY(location_id) REFERENCES locations(id)
        )
    ''')

    conn.commit()

def store_forecast(location_id, forecast_data):
    conn = get_db_connection()
    cursor = conn.cursor()

    for date_entry in forecast_data['data'][0]['coordinates'][0]['dates']:
        cursor.execute('''
            INSERT INTO forecasts (location_id, date, temp) 
            VALUES (?, ?, ?)
        ''', (location_id, date_entry['date'], date_entry['value']))

    conn.commit()

def fetch_forecast(location):
    lat = location['lat']
    lon = location['lon']
    
    start_date = datetime.now().strftime('%Y-%m-%dT%H:%M:%SZ')
    end_date = (datetime.now() + timedelta(days=7)).strftime('%Y-%m-%dT%H:%M:%SZ')

    url = f"{METEOMATICS_API_BASE}/{start_date}--{end_date}:P1D/t_2m:C/{lat},{lon}/json"
    
    response = requests.get(url, auth=(API_USERNAME, API_PASSWORD))

    if response.status_code == 200:
        conn = get_db_connection()
        cursor = conn.cursor()

        cursor.execute("SELECT id FROM locations WHERE name = ?", (location['name'],))
        existing_location = cursor.fetchone()

        if existing_location:
            location_id = existing_location['id']
        else:
            cursor.execute("INSERT INTO locations (name, latitude, longitude) VALUES (?, ?, ?)", 
                           (location['name'], lat, lon))
            location_id = cursor.lastrowid 
            conn.commit()

        store_forecast(location_id, response.json())

        return response.json()
    else:
        print(f"Error for {location['name']}: {response.text}")
        return {"error": f"Failed to fetch forecast for {location['name']}", "details": response.text}

@app.route('/fetch-forecast', methods=['GET'])
def fetch_forecast_for_all():
    forecast_data = {}
    
    for location in locations:
        forecast = fetch_forecast(location)
        forecast_data[location['name']] = forecast
    
    return jsonify(forecast_data)

@app.route('/locations', methods=['GET'])
def list_locations():
    conn = get_db_connection()
    cursor = conn.cursor()

    cursor.execute("SELECT * FROM locations")
    locations = cursor.fetchall()

    conn.close()

    return jsonify([dict(location) for location in locations])

@app.route('/latest-forecast', methods=['GET'])
def latest_forecast():
    conn = get_db_connection()
    cursor = conn.cursor()

    cursor.execute('''
        SELECT l.name, l.latitude, l.longitude, f.date, f.temp
        FROM forecasts f
        JOIN locations l ON f.location_id = l.id
        WHERE f.date = (
            SELECT MAX(date)
            FROM forecasts f2
            WHERE f2.location_id = f.location_id
        )
    ''')

    latest_forecasts = cursor.fetchall()
    conn.close()

    return jsonify([dict(forecast) for forecast in latest_forecasts])

@app.route('/average-temp', methods=['GET'])
def average_temp():
    conn = get_db_connection()
    cursor = conn.cursor()

    cursor.execute('''
        SELECT l.name, l.latitude, l.longitude, AVG(f.temp) as avg_temp
        FROM forecasts f
        JOIN locations l ON f.location_id = l.id
        WHERE f.id IN (
            SELECT id
            FROM forecasts f2
            WHERE f2.location_id = f.location_id
            ORDER BY date DESC
            LIMIT 3
        )
        GROUP BY l.id
    ''')

    averages = cursor.fetchall()
    conn.close()

    return jsonify([dict(avg) for avg in averages])

@app.route('/top-locations', methods=['GET'])
def top_locations():
    metric = request.args.get('metric', 'temp')
    n = int(request.args.get('n', 3))

    conn = get_db_connection()
    cursor = conn.cursor()

    cursor.execute(f'''
        SELECT l.name, l.latitude, l.longitude, AVG(f.{metric}) as avg_{metric}
        FROM forecasts f
        JOIN locations l ON f.location_id = l.id
        GROUP BY l.id
        ORDER BY avg_{metric} DESC
        LIMIT ?
    ''', (n,))

    top_locations = cursor.fetchall()
    conn.close()

    return jsonify([dict(location) for location in top_locations])


@app.route('/')
def index():
    return render_template('index.html')

if __name__ == '__main__':
    # Use app context to run the init_db function
    with app.app_context():
        init_db()  # Initialize the database tables
    app.run(debug=True)
