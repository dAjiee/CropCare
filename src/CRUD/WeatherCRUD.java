/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Source.Weather;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class WeatherCRUD {
    public static ArrayList<Weather> weatherList = new ArrayList<>();

    public static void createWeather(Weather weather) {
        weatherList.add(weather);
    }

    public static Weather retrieveWeather(Weather weather) {
        for (Weather w: weatherList) {
            if (w.equals(weather)) return w;
        }
        return null;
    }

    public static void updateWeather(Weather weather, Weather newWeather) {
        Weather tempWeather = retrieveWeather(weather);
        if (tempWeather != null) {
            tempWeather.setDate(newWeather.getDate());
            tempWeather.setStatus(newWeather.getStatus());
            tempWeather.setFarmerid(newWeather.getFarmerid());
            tempWeather.setId(newWeather.getId());
            tempWeather.setFieldid(newWeather.getFieldid());
        }
    }

    public static void deleteWeather(Weather weather) {
        boolean found = false;
        for (int i = 0; i < weatherList.size() && !found; i++) {
            found = weatherList.get(i).equals(weather);
            if (found) {
                weatherList.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Weather weather: weatherList) {
            str.append(weather.getFarmerid()).append(";")
               .append(weather.getFieldid()).append(";")
               .append(weather.getId()).append(";")
               .append(weather.getDate()).append(";")
               .append(weather.getStatus()).append("\n");
        }
        return str.toString();
    }
}
