package com.example.outdoorplanner.ui.weather;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.outdoorplanner.databinding.FragmentWeatherBinding;
import com.example.outdoorplanner.ui.weatherapi.WeatherAPI;

public class WeatherFragment extends Fragment {

    private FragmentWeatherBinding binding;
    WeatherAPI call;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WeatherViewModel searchViewModel =
                new ViewModelProvider(this).get(WeatherViewModel.class);

        binding = FragmentWeatherBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
/*
        call = new WeatherAPI();
        Context viewModelContext = binding.getRoot().getContext();
        call.sendRequest(viewModelContext);
*/
        final TextView textView = binding.textWeather;
        searchViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final TextView weatherTextViewLocation = binding.weatherCurrentLocation;
        searchViewModel.getLocation().observe(getViewLifecycleOwner(), weatherTextViewLocation::setText);

        final TextView weatherTextViewCurrentTemperature = binding.weatherCurrentTemperature;
        searchViewModel.getCurrentTemp().observe(getViewLifecycleOwner(), weatherTextViewCurrentTemperature::setText);

        final RecyclerView rvHourlyForecast = binding.rvHourlyForecast;
        String test[] = {"09:00", "10:00",  "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
        WeatherAdapter_HourlyForecast adapter_hourlyForecast = new WeatherAdapter_HourlyForecast(getContext(), test);
        rvHourlyForecast.setAdapter(adapter_hourlyForecast);

        final RecyclerView rvDailyForecast = binding.rvDailyForecast;
        String test2[] = {"today", "tomorrow",  "11.08.", "12.08.", "13.08.", "14.08.", "15.08", "16.08.", "17.08."};
        WeatherAdapter_DailyForecast adapter_dailyForecast = new WeatherAdapter_DailyForecast(getContext(), test2);
        rvDailyForecast.setAdapter(adapter_dailyForecast);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}