package pl.sda;

import lombok.Data;
import org.apache.commons.io.IOUtils;
import pl.sda.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;


@Data
public abstract class AbstractJsonData {


    private String finalURL;
    private String url;
    private String apiKey;
    private String data = "";
    private String city;

    public AbstractJsonData() {
        this.finalURL = this.url + "?key=" + apiKey + "&q=";

    }

    public void build() {
        this.finalURL = this.url + "?key=" + apiKey + "&q=";
    }

    public String getJData(String city) {
        if (data.isEmpty()) {
            this.finalURL = this.finalURL + city;
            try {
                this.data = IOUtils.toString(new URL(this.finalURL),
                        Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;

    }

    abstract Weather getWeather(); //sygnatura funkcji

}