package pl.wroclaw.asma.controller.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import pl.wroclaw.asma.Config;
import pl.wroclaw.asma.model.WeatherForecast;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApiClientService extends Service<WeatherForecast>  {

    private String longitude;
    private String latitude;

    public WeatherApiClientService(String latitude, String longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    protected Task<WeatherForecast> createTask() {
        return new Task<pl.wroclaw.asma.model.WeatherForecast>() {
            @Override
            protected WeatherForecast call() throws Exception {
                return getWeatherForecast();
            }
        };
    }

    private WeatherForecast getWeatherForecast() {
        WeatherForecast weatherForecast = new WeatherForecast();
        HttpClient client = HttpClient.newHttpClient();
        URI requestURL =  createRequestURI();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(requestURL)
                .build();
        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            weatherForecast = objectMapper.readValue(response.body(), WeatherForecast.class);
            //System.out.println(objectMapper.writeValueAsString(weatherForecast));


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return weatherForecast;
    }

    public URI createRequestURI(){

        URI requestURL =  URI.create("https://api.openweathermap.org/data/2.5/onecall?lat=" + latitude + "&lon=" +
                longitude + "&units=metric&lang=en&exclude=minutely,hourly,alerts&appid=" + Config.getOpenWeatherMapApiKey());

        return requestURL;
    }

}
