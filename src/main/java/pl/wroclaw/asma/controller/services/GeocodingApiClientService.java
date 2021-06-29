package pl.wroclaw.asma.controller.services;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import pl.wroclaw.asma.Config;
import pl.wroclaw.asma.model.CityCoordinates;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GeocodingApiClientService extends Service<CityCoordinates> {

    private String city;
    private String countryCode;

    public GeocodingApiClientService(String city, String countryCode ) {
        this.city = city;
        this.countryCode = countryCode;
    }


    @Override
    protected Task<CityCoordinates> createTask() {
        return new Task<pl.wroclaw.asma.model.CityCoordinates>() {
            @Override
            protected CityCoordinates call() throws Exception {
                return getCityCoordinates();
            }
        };
    }

    private CityCoordinates getCityCoordinates(){
        CityCoordinates cityCoordinates = new CityCoordinates();
        HttpClient client = HttpClient.newHttpClient();
        URI requestURL =  createRequestURI(this.city, this.countryCode);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(requestURL)
                .build();
        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            CityCoordinates[] cityCoordinatesArray = objectMapper.readValue(response.body(), CityCoordinates[].class);
            cityCoordinates = cityCoordinatesArray[0];

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cityCoordinates;
    }

    public URI createRequestURI(String city, String countryCode){
        URI requestURL =  URI.create("http://api.openweathermap.org/geo/1.0/direct?q=" + city + "," + countryCode +
                "&limit=1&appid=" + Config.getOpenWeatherMapApiKey() );
        return requestURL;
    }
}
