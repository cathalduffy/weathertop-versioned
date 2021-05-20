package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

import static models.Station.codeToString;
import static models.Station.windToBeaufort;
import static models.Station.windDirectionCompass;
import static models.Station.weatherIcon;


public class Dashboard extends Controller {

    public static void index() {

            Logger.info("Rendering Dashboard");
            Member member = Accounts.getLoggedInMember();
            List<Station> stations = ((Member) member).stations;



       stations = Station.findAll();

        for (Station station : stations) {
            if (station.readings.size() > 0) {
                station.setWeatherConditions(codeToString(station.readings.get(station.readings.size() - 1).code));

                station.setWindToBeau(windToBeaufort(station.readings.get(station.readings.size() - 1).windSpeed));

                station.setWindCompass(windDirectionCompass(station.readings.get(station.readings.size() - 1).windDirection));

                station.setWeatherIcon(weatherIcon(station.readings.get(station.readings.size() - 1).windDirection));

            }
        }
        render("dashboard.html", member, stations);

    }



    public static void addStation (String name, float lat, float lng)
    {
        Station station = new Station (name, lat, lng);
        Logger.info ("Adding a new station called " + name);
        station.save();
        redirect ("/dashboard");
    }

    }
    

