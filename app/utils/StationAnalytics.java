package utils;

import models.Reading;

import java.util.List;

public class StationAnalytics {

    public static float getSmallestTemperature(List<Reading> readings) {
        Reading smallestTemp = null;
        if (readings.size() > 0) {
            smallestTemp = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature < smallestTemp.temperature) {
                    smallestTemp = reading;
                }
            }
        }
        return smallestTemp.temperature;
    }

    public static float getLargestTemperature(List<Reading> readings) {
        Reading largestTemp = null;
        if (readings.size() > 0) {
            largestTemp = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature > largestTemp.temperature) {
                    largestTemp = reading;
                }
            }
        }
        return largestTemp.temperature;
    }

    public static float getSmallestTWindSpeed(List<Reading> readings) {
        Reading smallestWind = null;
        if (readings.size() > 0) {
            smallestWind = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed < smallestWind.windSpeed) {
                    smallestWind = reading;
                }
            }
        }
        return smallestWind.windSpeed;
    }

    public static float getLargestTWindSpeed(List<Reading> readings) {
        Reading largestWind = null;
        if (readings.size() > 0) {
            largestWind = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed > largestWind.windSpeed) {
                    largestWind = reading;
                }
            }
        }
        return largestWind.windSpeed;
    }

    public static int getSmallestTPressure(List<Reading> readings) {
        Reading smallestPressure = null;
        if (readings.size() > 0) {
            smallestPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure < smallestPressure.pressure) {
                    smallestPressure = reading;
                }
            }
        }
        return smallestPressure.pressure;
    }

    public static int getLargestPressure(List<Reading> readings) {
        Reading largestPressure = null;
        if (readings.size() > 0) {
            largestPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure > largestPressure.pressure) {
                    largestPressure = reading;
                }
            }
        }
        return largestPressure.pressure;
    }




}
