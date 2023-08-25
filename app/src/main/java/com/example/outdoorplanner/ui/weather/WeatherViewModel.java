package com.example.outdoorplanner.ui.weather;

import static java.security.AccessController.getContext;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.outdoorplanner.ui.weatherapi.RestInterface;
import com.example.outdoorplanner.ui.weatherapi.WeatherAPI;

public class WeatherViewModel extends ViewModel implements RestInterface {
    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> location;
    private final MutableLiveData<String> currentTemp;

    public WeatherViewModel() {
        WeatherAPI call;
        call = new WeatherAPI();
        call.registerRestEventListener(this);
        // call.sendRequest(getContext());

        mText = new MutableLiveData<>();
        mText.setValue("This is weather fragment");
        location = new MutableLiveData<>();
        location.setValue("Weingarten");
        currentTemp = new MutableLiveData<>();
        currentTemp.setValue("21.7 °C");

    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getCurrentTemp(){ return currentTemp; }
    public LiveData<String> getLocation(){ return location; }

    @Override
    public void onNewCurrentWeatherFromRest(String[] currentWeather) {
        
    }
}