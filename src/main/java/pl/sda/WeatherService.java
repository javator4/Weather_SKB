package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;

public class WeatherService {

    private String finalURL;
    private String url;
    private String apiKey;
    private String data="";


    public WeatherService(String url, String apiKey) {

        this.apiKey = apiKey;
        this.url = url;
        this.finalURL = this.url + "?key=" + apiKey + "&q=";
    }

    public WeatherService getJData(String city) {
        if (data.isEmpty()) {
            this.finalURL = this.finalURL + city;
            try {
                this.data = IOUtils.toString(new URL(this.finalURL),
                        Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return this;

    }

    public Location getLocation() {


       JSONObject jsonObject = new JSONObject(this.data);

       String lat = jsonObject.getJSONObject("location")
               .get("lat").toString();
      String lon = jsonObject.getJSONObject("location")
              .get("lon").toString();

       Location location = Location.builder()
               .lat(Float.parseFloat(lat))
               .lon(Float.parseFloat(lon))
               .build();

        return location;
    }




    public Current getCityWeather() {

        JSONObject jsonObject = new JSONObject(this.data);


        String temp = jsonObject.getJSONObject("current")
                .get("temp_c").toString();
        String temp_f = jsonObject.getJSONObject("current")
                .get("temp_f").toString();
        String wind_mph = jsonObject.getJSONObject("current")
                .get("wind_mph").toString();
        String wind_kph = jsonObject.getJSONObject("current")
                .get("wind_kph").toString();
        String pressure_mb = jsonObject.getJSONObject("current")
                .get("pressure_mb").toString();
        String pressure_in = jsonObject.getJSONObject("current")
                .get("pressure_in").toString();
        String humidity = jsonObject.getJSONObject("current")
                .get("humidity").toString();
        String feelslike_c = jsonObject.getJSONObject("current")
                .get("feelslike_c").toString();


        Current current = Current.builder()
                .temp_c(Float.parseFloat(temp))
                .temp_f(Float.parseFloat(temp_f))
                .wind_mph(Float.parseFloat(wind_mph))
                .wind_kph(Float.parseFloat(wind_kph))
                .pressure_in(Float.parseFloat(pressure_in))
                .pressure_mb(Float.parseFloat(pressure_mb))
                .humidity(Integer.parseInt(humidity))
                .feelslike_c(Float.parseFloat(feelslike_c))
                .build();



         /*   current.setTemp_c(Float.parseFloat(temp));
            current.setTemp_f(Float.parseFloat(temp_f));
            current.setWind_mph(Float.parseFloat(wind_mph));
            current.setWind_kph(Float.parseFloat(wind_kph));
            current.setPressure_mb(Float.parseFloat(pressure_mb));
            current.setPressure_in(Float.parseFloat(pressure_in));
            current.setHumidity(Integer.parseInt(humidity)); */


        return current;
    }

}

