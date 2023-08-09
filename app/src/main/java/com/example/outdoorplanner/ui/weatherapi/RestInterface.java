package com.example.outdoorplanner.ui.weatherapi;

import org.json.JSONObject;

public interface RestInterface {

    void onNewCurrentWeatherFromRest(String[] currentWeather);
}
