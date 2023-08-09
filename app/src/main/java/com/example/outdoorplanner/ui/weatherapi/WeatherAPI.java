package com.example.outdoorplanner.ui.weatherapi;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherAPI {
/*
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m,relativehumidity_2m,precipitation_probability,precipitation,rain,showers,snowfall,snow_depth,weathercode,cloudcover,windspeed_10m,winddirection_10m,windgusts_10m&daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,uv_index_max,uv_index_clear_sky_max,precipitation_sum,rain_sum,showers_sum,snowfall_sum,precipitation_probability_max,windspeed_10m_max,windgusts_10m_max,winddirection_10m_dominant&current_weather=true&timezone=auto";

    // Test Variables
    private double latitude = 52.52;
    private double longitude = 13.41;
//  text_home
 */

    private RestInterface restListener;
    public void registerRestEventListener(RestInterface mRestListener) {
        this.restListener = mRestListener;
    }

    private RequestQueue queue;
    private String url = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m,relativehumidity_2m,precipitation_probability,precipitation,rain,showers,snowfall,snow_depth,weathercode,cloudcover,windspeed_10m,winddirection_10m,windgusts_10m&daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,uv_index_max,uv_index_clear_sky_max,precipitation_sum,rain_sum,showers_sum,snowfall_sum,precipitation_probability_max,windspeed_10m_max,windgusts_10m_max,winddirection_10m_dominant&current_weather=true&timezone=auto";


    protected void sendRequest(Context context) {

        queue = Volley.newRequestQueue(context);
        final String[] currentWeather = new String[6];

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject weatherData = response.getJSONObject("data");
                    JSONObject currentWeatherData = weatherData.getJSONObject("current_weather");
                    currentWeather[0] = currentWeatherData.getString("temperature");
                    currentWeather[1] = currentWeatherData.getString("windspeed");
                    currentWeather[2] = currentWeatherData.getString("winddirection");
                    currentWeather[3] = currentWeatherData.getString("weathercode");
                    currentWeather[4] = currentWeatherData.getString("is_day");
                    currentWeather[5] = currentWeatherData.getString("time");

                    restListener.onNewCurrentWeatherFromRest(currentWeather);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(jsonObjectRequest);
    }
}
