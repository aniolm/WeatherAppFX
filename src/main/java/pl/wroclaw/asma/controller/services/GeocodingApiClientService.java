package pl.wroclaw.asma.controller.services;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import pl.wroclaw.asma.model.CityCoordinates;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GeocodingApiClientService extends Service<Void> {

    private String city;
    private String countryCode;
    //private CityCoordinates cityCoordinates = new CityCoordinates(0.0,0.0);



    public GeocodingApiClientService(String city, String countryCode ) {
        this.city = city;
        this.countryCode = countryCode;
    }

    @Override
    protected Task createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                getCityCoordinates();
                return null;
            }
        };
    }

    private void getCityCoordinates(){
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
            CityCoordinates[] cityCoordinates = objectMapper.readValue(response.body(), CityCoordinates[].class);
            System.out.println(objectMapper.writeValueAsString(cityCoordinates));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public URI createRequestURI(String city, String countryCode){

        URI requestURL =  URI.create("http://api.openweathermap.org/geo/1.0/direct?q=" + city + "," + countryCode + "&limit=1&appid=99906e25ff6d624254c547ed44f5914f");
        return requestURL;
    }
}
