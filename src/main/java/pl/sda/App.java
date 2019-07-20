package pl.sda;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;//do komentarzy
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class App {

    private static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Uruchomienie aplikacji: ");
        logger.warn("Warning");
        logger.debug("Debug mode");
        logger.error("ERROR ");


        String url = "http://api.apixu.com/v1/current.json?key=2ba889217eed469cb8a81157191307&q=Paris";

        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json",
                "2ba889217eed469cb8a81157191307");


        WeatherForecast weatherForecast = new OrgImplementation(weatherService, "Torun");
        WeatherForecast weatherForecast1 = new FasterImplementation(weatherService, "Torun");

        System.out.println(weatherForecast.getWeather());
        System.out.println(weatherForecast1.getWeather());


    }
}

