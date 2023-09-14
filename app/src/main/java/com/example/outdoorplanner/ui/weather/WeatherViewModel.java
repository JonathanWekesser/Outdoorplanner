package com.example.outdoorplanner.ui.weather;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.outdoorplanner.ui.weatherapi.RestInterface;
import com.example.outdoorplanner.ui.weatherapi.WeatherAPI;

import org.json.JSONObject;

public class WeatherViewModel extends ViewModel implements RestInterface {

    WeatherAPI call;

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> location;
    private final MutableLiveData<String> currentTemp;


    public WeatherViewModel() {
        call = new WeatherAPI();
        call.registerRestEventListener(this);
        Context context = createContext();
        call.sendRequest(context);

        mText = new MutableLiveData<>();
        mText.setValue("This is weather fragment");
        location = new MutableLiveData<>();
        location.setValue("Weingarten");
        currentTemp = new MutableLiveData<>();
        currentTemp.setValue("21.7 °C");

    }

    private Context createContext() {
        Context context = this.createContext();
        return context;
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getCurrentTemp(){ return currentTemp; }
    public LiveData<String> getLocation(){ return location; }

    @Override
    public void onNewCurrentWeatherFromRest(JSONObject currentWeather) {

    }
}