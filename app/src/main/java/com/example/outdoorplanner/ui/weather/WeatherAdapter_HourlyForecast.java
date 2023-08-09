package com.example.outdoorplanner.ui.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.outdoorplanner.R;

public class WeatherAdapter_HourlyForecast extends RecyclerView.Adapter<WeatherAdapter_HourlyForecast.hourlyForecastViewHolder>{

    Context context;
    String testString[];

    public WeatherAdapter_HourlyForecast(Context context, String testString[]) {

        this.context = context;
        this.testString = testString;
    }

    @NonNull
    @Override
    public hourlyForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_hourly_forecast,parent,false);
        return new hourlyForecastViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull hourlyForecastViewHolder holder, int position) {

        String newString = testString[position];
        holder.tvText.setText(testString[position]);
    }

    @Override
    public int getItemCount() {

        return testString.length;
    }

    public static class hourlyForecastViewHolder extends RecyclerView.ViewHolder {

        TextView tvText;

        public hourlyForecastViewHolder(@NonNull View itemView) {
            super(itemView);

            tvText = itemView.findViewById(R.id.textView);
        }
    }
}
