package pl.sda;


import pl.sda.model.Current;

public class App
{

    public static void main(String[] args )
    {

        System.out.println("Hello world");
        String city="Torun";

        WeatherService weatherService= new WeatherService("http://api.apixu.com/v1/current.json",
                "2ba889217eed469cb8a81157191307");



       Current current =  weatherService.getCityWeather("Torun");
        System.out.println("Temp w miescie " + city + ": " + current.getTemp_c() + "C");
        System.out.println("Ciśnienie wynosi "+current.getPressure_in());

        }
    }

