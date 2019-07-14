package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.model.Weather;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FasterImplementation implements WeatherForecast{

    String url = "http://api.apixu.com/v1/current.json?key=2ba889217eed469cb8a81157191307&q=Paris";
    private WeatherService weatherService;
    private String city;

    public FasterImplementation(WeatherService weatherService, String city) {
        this.weatherService=weatherService;
        this.city=city;
    }

    @Override
    public Weather getWeather() {

        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather=null;
        try {
            weather = objectMapper.readValue(this.weatherService.getJData(this.city), Weather.class);

            objectMapper.writeValue(new File("data.json"), weather);

            System.out.println(weather.getLocation().getCountry());
            System.out.println(weather.getLocation().getLocaltime());
        } catch (IOException e) {
            e.printStackTrace();
        }return weather;
    }
}
