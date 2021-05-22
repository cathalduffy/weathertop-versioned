package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;
import java.sql.Timestamp;

import static models.Station.*;

public class StationCtrl extends Controller
{

    public static void index(Long id)
    {
       Station station = Station.findById(id);      //getting the readings by the station id and displaying in stations page
         {
            if (station.readings.size() > 0) {
                station.setWeatherConditions(codeToString(station.readings.get(station.readings.size() - 1).code));

                station.setWindToBeau(windToBeaufort(station.readings.get(station.readings.size() - 1).windSpeed));

                station.setWindCompass(windDirectionCompass(station.readings.get(station.readings.size() - 1).windDirection));

                station.setWeatherIcon(weatherIcon(station.readings.get(station.readings.size() - 1).code));

                station.smallestTemperature = StationAnalytics.getSmallestTemperature(station.readings);
                station.largestTemperature = StationAnalytics.getLargestTemperature(station.readings);
                station.smallestWindSpeed = StationAnalytics.getSmallestTWindSpeed(station.readings);
                station.largestWindSpeed = StationAnalytics.getLargestTWindSpeed(station.readings);
                station.smallestPressure = StationAnalytics.getSmallestTPressure(station.readings);
                station.largestPressure = StationAnalytics.getLargestPressure(station.readings);
            }
        }
               Logger.info ("Station id = " + id);
                render("station.html", station);
    }


    public static void deletereading (Long id, Long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        render("station.html", station);
    }

    public static void addReading(Long id, int code, float temperature, float windSpeed, int windDirection, int pressure)
    {
        Station station = Station.findById(id);
        Timestamp time = new Timestamp(System.currentTimeMillis());
        Reading reading = new Reading(time, code, temperature, windSpeed, windDirection, pressure);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }

}
