package pl.sda;


import pl.sda.model.Current;
import pl.sda.model.Location;

public class App {

    public static void main(String[] args) {


     //   String city = "Paris";

        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json",
                "2ba889217eed469cb8a81157191307");


      /*  Current current = weatherService.getCityWeather("Torun");
        System.out.println("Temperature in " + city + ": " + current.getTemp_c() + "C");
        System.out.println("Feels like, feels like it's  " + current.getFeelslike_c() + "C" + " in " + city);
        System.out.println("Pressure in  " + city + ": " + current.getPressure_mb()); */

     Current current= weatherService.getJData("Torun").getCityWeather();
     Location location=weatherService.getJData("Torun").getLocation();

        System.out.println(current);
        System.out.println("Lat: "+location.getLat());
        System.out.println("Lon: "+location.getLon());
    }
}

