package com.example.outdoorplanner.ui.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.outdoorplanner.R;

import org.w3c.dom.Text;

public class WeatherAdapter_DailyForecast extends RecyclerView.Adapter<WeatherAdapter_DailyForecast.dailyForecastViewHolder> {

    Context context;
    String testString[];

    public WeatherAdapter_DailyForecast(Context context, String testString[]) {

        this.context = context;
        this.testString = testString;
    }

    @NonNull
    @Override
    public dailyForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_daily_forecast,parent,false);
        return new dailyForecastViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull dailyForecastViewHolder holder, int position) {

        String newString = testString[position];
        holder.tvText.setText(testString[position]);
    }

    @Override
    public int getItemCount() {

        return testString.length;
    }

    public static class dailyForecastViewHolder extends RecyclerView.ViewHolder {

        TextView tvText;
        public dailyForecastViewHolder(@NonNull View itemView) {
            super(itemView);

            tvText = itemView.findViewById(R.id.cardDailyDate);
        }
    }
}
