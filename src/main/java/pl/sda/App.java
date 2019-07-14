package pl.sda;


import pl.sda.model.Current;

public class App {

    public static void main(String[] args) {


        String city = "Torun";

        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json",
                "2ba889217eed469cb8a81157191307");


        Current current = weatherService.getCityWeather("Torun");
        System.out.println("Temperature in " + city + ": " + current.getTemp_c() + "C");
        System.out.println("Pressure in  " + city + ": " +current.getPressure_mb());

    }
}

