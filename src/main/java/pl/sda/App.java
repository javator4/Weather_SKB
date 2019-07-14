package pl.sda;


import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class App {

    public static void main(String[] args) {


     /*  //String city = "Paris";



    //  Current current = weatherService.getCityWeather("Torun");
       // System.out.println("Temperature in " + city + ": " + current.getTemp_c() + "C");
        //System.out.println("Feels like, feels like it's  " + current.getFeelslike_c() + "C" + " in " + city);
        //System.out.println("Pressure in  " + city + ": " + current.getPressure_mb());


     Location location=weatherService.getJData("Torun").getLocation();


        System.out.println("Lat: "+location.getLat());
        System.out.println("Lon: "+location.getLon()); */

        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json",
                "2ba889217eed469cb8a81157191307");
        Current current = weatherService.getJData("Torun").getCityWeather();
        String url = "http://api.apixu.com/v1/current.json?key=2ba889217eed469cb8a81157191307&q=Paris";

        System.out.println(current);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Weather weather = objectMapper.readValue(new URL(url), Weather.class);

            objectMapper.writeValue(new File("data.json"), weather);

            System.out.println(weather.getLocation().getCountry());
            System.out.println(weather.getLocation().getLocaltime());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

