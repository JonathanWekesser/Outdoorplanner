package com.example.outdoorplanner.ui;

public class weatherIcons {

    public String getIconFromCode(int weatherCode, boolean isDay) {
        String icon = null;
        if (weatherCode < 1) {

        } else if (weatherCode < 4) {

        } else if (weatherCode < 49) {

        } else if (weatherCode < 56) {

        } else if (weatherCode < 58) {

        } else if (weatherCode < 66) {

        } else if (weatherCode < 68) {

        } else if (weatherCode < 76) {

        } else if (weatherCode < 78) {

        } else if (weatherCode < 83) {

        } else if (weatherCode < 87) {

        } else if (weatherCode < 96) {

        } else if (weatherCode < 100) {

        }
        return icon;
    }
}

/*
Code	Description
0	Clear sky
1, 2, 3	Mainly clear, partly cloudy, and overcast
45, 48	Fog and depositing rime fog
51, 53, 55	Drizzle: Light, moderate, and dense intensity
56, 57	Freezing Drizzle: Light and dense intensity
61, 63, 65	Rain: Slight, moderate and heavy intensity
66, 67	Freezing Rain: Light and heavy intensity
71, 73, 75	Snow fall: Slight, moderate, and heavy intensity
77	Snow grains
80, 81, 82	Rain showers: Slight, moderate, and violent
85, 86	Snow showers slight and heavy
95 *	Thunderstorm: Slight or moderate
96, 99 *	Thunderstorm with slight and heavy hail



 */