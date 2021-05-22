package models;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
    public String name;
    public float lat;
    public float lng;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();
    public String weatherConditions;
    public int windToBeau;
    public String windCompass;
    public String weatherIcon;
    public float smallestTemperature;
    public float largestTemperature;
    public float smallestWindSpeed;
    public float largestWindSpeed;
    public int smallestPressure;
    public int largestPressure;


    public Station(String name, float lat, float lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }


    public static String codeToString(int code) {

        switch (code) {
            case 100:
                return "Clear";

            case 200:
                return "Partial Clouds";

            case 300:
                return "Cloudy";

            case 400:
                return "Light Showers";

            case 500:
                return "Heavy Showers";

            case 600:
                return "Rain";

            case 700:
                return "Snow";

            case 800:
                return "Thunder";

        }
        return "";
    }


    public int listPressure() {              //method to display the latest reading of pressure
        if (this.readings.size() == 0) {
            return 0;
        } else {
            int listOfPressure = 0;

            listOfPressure = this.readings.get(this.readings.size() - 1).pressure;

            return listOfPressure;
        }
    }

    public float listTemp() {                          //method to display temp C
        if (this.readings.size() == 0) {
            return 0;
        } else {
            float listOfTemp = 0;

            listOfTemp = this.readings.get(this.readings.size() - 1).temperature;

            return listOfTemp;
        }
    }

    public float celsiusToFahrenheit() {                //method to change temp from C to F

        if (this.readings.size() == 0) {
            return 0;
        } else {
            float Fahrenheit = 0;

            Fahrenheit = this.readings.get(this.readings.size() - 1).temperature * 9 / 5 + 32;

            return Fahrenheit;
        }
    }

    public static int windToBeaufort(float windSpeed) {
        if (windSpeed <= 1) {
            return 0;
        } else if (windSpeed > 1 && windSpeed <= 5) {
            return 1;
        } else if (windSpeed >= 6 && windSpeed <= 11) {
            return 2;
        } else if (windSpeed >= 12 && windSpeed <= 19) {
            return 3;
        } else if (windSpeed >= 20 && windSpeed <= 28) {
            return 4;
        } else if (windSpeed >= 29 && windSpeed <= 38) {
            return 5;
        } else if (windSpeed >= 39 && windSpeed <= 49) {
            return 6;
        } else if (windSpeed >= 50 && windSpeed <= 61) {
            return 7;
        } else if (windSpeed >= 62 && windSpeed <= 74) {
            return 8;
        } else if (windSpeed >= 75 && windSpeed <= 88) {
            return 9;
        } else if (windSpeed >= 89 && windSpeed <= 102) {
            return 10;
        } else if (windSpeed >= 113 && windSpeed <= 117) {
            return 11;
        } else {
            return 0;
        }
    }

    public static String windDirectionCompass(int windDirection) {
        if (windDirection > 348.75 && windDirection <= 11.25) {
            return "North";
        } else if (windDirection > 11.25 && windDirection <= 33.75) {
            return "North North East";
        } else if (windDirection > 33.75 && windDirection <= 56.25) {
            return "North East";
        } else if (windDirection > 56.25 && windDirection <= 78.75) {
            return "East North East";
        } else if (windDirection > 78.75 && windDirection <= 101.25) {
            return "East";
        } else if (windDirection > 101.25 && windDirection <= 123.75) {
            return "East South East";
        } else if (windDirection > 123.75 && windDirection <= 146.25) {
            return "South East";
        } else if (windDirection > 146.25 && windDirection <= 168.75) {
            return "South South East";
        } else if (windDirection > 168.75 && windDirection <= 191.25) {
            return "South";
        } else if (windDirection > 191.25 && windDirection <= 213.75) {
            return "South South West";
        } else if (windDirection > 213.75 && windDirection <= 263.25) {
            return "South West";
        } else if (windDirection > 236.25 && windDirection <= 258.75) {
            return "West South West";
        } else if (windDirection > 258.75 && windDirection <= 281.25) {
            return "West";
        } else if (windDirection > 281.25 && windDirection <= 303.75) {
            return "West North West";
        } else if (windDirection > 303.75 && windDirection <= 326.25) {
            return "North West";
        } else if (windDirection > 236.25 && windDirection <= 258.75) {
            return "North North West";

        } else {
            return "Inaccurate reading";
        }
    }

    public float windChillCalculator() {                //method for wind chill calculate

        if (this.readings.size() == 0) {
            return 0;
        } else {
            float windChill = 0;
            float t = this.readings.get(this.readings.size() - 1).temperature;
            float w = this.readings.get(this.readings.size() - 1).windSpeed;

            windChill = (float) (13.12 + 0.6215 * t - 11.37 * Math.pow(w, 0.16) + 0.3965 * t * Math.pow(w, 0.16));

            return windChill;
        }
    }

    public static String weatherIcon(int code) {
        HashMap<Integer, String> weatherIcons = new HashMap<Integer, String>();
        weatherIcons.put(100, "sun icon");
        weatherIcons.put(200, "cloud sun icon");
        weatherIcons.put(300, "cloud icon");
        weatherIcons.put(400, "cloud sun rain icon");
        weatherIcons.put(500, "cloud showers heavy icon");
        weatherIcons.put(600, "cloud rain icon");
        weatherIcons.put(700, "snowflake icon");
        weatherIcons.put(800, "poo storm icon");
        return weatherIcons.get(code);
    }


    public String getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(String weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public void setWindToBeau(int windToBeau) {
        this.windToBeau = windToBeau;
    }

    public void setWindCompass(String windCompass) {
        this.windCompass = windCompass;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }
}