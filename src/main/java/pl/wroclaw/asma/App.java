package pl.wroclaw.asma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pl.wroclaw.asma.controller.services.*;
import pl.wroclaw.asma.model.CityCoordinates;
import pl.wroclaw.asma.model.IpGeolocation;
import pl.wroclaw.asma.model.WeatherForecast;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/WeatherAppWindow.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        scene.getStylesheets().add("WeatherApp.css");
        stage.setTitle("Simple Weather App");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        //Positioning of application window in the right bottom corner
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) * 0.99;
        double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) * 0.92;
        stage.setX(x);
        stage.setY(y);


        PublicIpIdentificationService publicIpIdentificationService = new PublicIpIdentificationService();
        publicIpIdentificationService.start();
        publicIpIdentificationService.setOnSucceeded(event -> {

        IpGeolocationApiClientService ipGeolocationApiClientService = new IpGeolocationApiClientService(publicIpIdentificationService.getValue());
        ipGeolocationApiClientService.start();
        ipGeolocationApiClientService.setOnSucceeded(event1 -> {
            IpGeolocation ipGeolocation = ipGeolocationApiClientService.getValue();
            GeocodingApiClientService geocodingApiClientService = new GeocodingApiClientService(ipGeolocation.getCity(), ipGeolocation.getCity());
            geocodingApiClientService.start();

            geocodingApiClientService.setOnSucceeded(event2 -> {
                CityCoordinates cityCoordinates = geocodingApiClientService.getValue();
                WeatherApiClientService weatherApiClientService = new WeatherApiClientService(cityCoordinates.getLat(),cityCoordinates.getLon());
                weatherApiClientService.start();

                weatherApiClientService.setOnSucceeded(event3 -> {
                    WeatherForecast weatherForecast = weatherApiClientService.getValue();
                    System.out.println(weatherForecast.getCurrentWeather().getTemp());
                    System.out.println(weatherForecast.getCurrentWeather().getPressure());
                    System.out.println(weatherForecast.getCurrentWeather().getHumidity());
                    });
                 });
        });
        });
    }

    public static void main(String[] args) {
        App.launch();
    }

}