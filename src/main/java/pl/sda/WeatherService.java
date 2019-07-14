package pl.sda;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pl.sda.model.Current;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {

    private String finalURL;
    private String url;
    private String apiKey;


    public WeatherService(String url, String key) {

        this.apiKey = key;
        this.url = url;
        this.finalURL = this.url + "?key=" + key + "&q=";
    }

    public Current getCityWeather(String city) {

        this.finalURL = this.finalURL + city;
        System.out.println(this.finalURL);


        try {
            String data = IOUtils.toString(new URL(this.finalURL),
                    Charset.forName("UTF-8"));
            JSONObject jsonObject = new JSONObject(data);

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


            System.out.println(temp);
            System.out.println(temp_f);
            System.out.println(wind_kph);
            System.out.println(wind_mph);
            System.out.println(pressure_in);
            System.out.println(pressure_mb);
            System.out.println(humidity);

            Current current = new Current();
            current.setTemp_c(Float.parseFloat(temp));
            current.setTemp_f(Float.parseFloat(temp_f));
            current.setWind_mph(Float.parseFloat(wind_mph));
            current.setWind_kph(Float.parseFloat(wind_kph));
            current.setPressure_mb(Float.parseFloat(pressure_mb));
            current.setPressure_in(Float.parseFloat(pressure_in));
            current.setHumidity(Integer.parseInt(humidity));


            return current;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}

