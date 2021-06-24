package pl.wroclaw.asma.controller;

import de.jensd.fx.glyphs.weathericons.WeatherIcon;
import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.wroclaw.asma.DateTime;
import pl.wroclaw.asma.IconResolver;
import pl.wroclaw.asma.ViewFactory;
import pl.wroclaw.asma.controller.services.*;
import pl.wroclaw.asma.model.CityCoordinates;
import pl.wroclaw.asma.model.IpGeolocation;
import pl.wroclaw.asma.model.WeatherForecast;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.*;

public class WeatherAppController implements Initializable {



    private String fxmlName;
    private ViewFactory viewFactory;
    private IpGeolocation ipGeolocation;
    private CityCoordinates cityCoordinates;
    private WeatherForecast weatherForecast;
    private Map<String, String> cityNames = new HashMap<String, String>();

    @FXML
    private TextField searchField;

    @FXML
    private Label cityLabel;

    @FXML
    private WeatherIconView currentWeatherIcon;

    @FXML
    private Label currentTempLabel;

    @FXML
    private Label currentWeatherLabel;

    @FXML
    private Label currentFeelsLikeLabel;

    @FXML
    private Label currenPressLabel;

    @FXML
    private Label currentWindSpeedLabel;

    @FXML
    private Label currentDateTimeLabel;

    @FXML
    private Label d1DayLabel;

    @FXML
    private Label d1DateLabel;

    @FXML
    private WeatherIconView d1WeatherIcon;

    @FXML
    private Label d1TempLabel;

    @FXML
    private Label d1WeatherLabel;

    @FXML
    private Label d2DayLabel;

    @FXML
    private Label d2DateLabel;

    @FXML
    private WeatherIconView d2WeatherIcon;

    @FXML
    private Label d2TempLabel;

    @FXML
    private Label d2WeatherLabel;

    @FXML
    private Label d3DayLabel;

    @FXML
    private Label d3DateLabel;

    @FXML
    private WeatherIconView d3WeatherIcon;

    @FXML
    private Label d3TempLabel;

    @FXML
    private Label d3WeatherLabel;

    @FXML
    private Label d4WeatherLabel;

    @FXML
    private Label d4DayLabel;

    @FXML
    private Label d4DateLabel;

    @FXML
    private WeatherIconView d4WeatherIcon;

    @FXML
    private Label d4TempLabel;

    @FXML
    private Label d5WeatherLabel;

    @FXML
    private Label d5DayLabel;

    @FXML
    private Label d5DateLabel;

    @FXML
    private WeatherIconView d5WeatherIcon;

    @FXML
    private Label d5TempLabel;

    public WeatherAppController( String fxmlName, ViewFactory viewFactory) {
        this.fxmlName = fxmlName;
        this.viewFactory = viewFactory;
    }

    public String getFxmlName() {
        return fxmlName;
    }

    @FXML
    void searchCity() {
        getWeather(searchField.getText());
    }

    @FXML
    void getCurrentLocation() {
        getLocation();
    }

    @FXML
    void openNewWindow() {
        createWindow();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //cityCoordinates.setName("Wroclaw");
        //cityCoordinates.setCountry("PL");
        setUpSearchTextField();
        getWeather("Wroclaw / PL");


    }


    public void setUpSearchTextField() {

        HashMap<String, String> cityList = new HashMap<String, String>();
        CityListLoaderService cityListLoaderService = new CityListLoaderService();
        cityListLoaderService.start();
        cityListLoaderService.setOnSucceeded(event -> {
            cityNames = cityListLoaderService.getValue();
            TextFields.bindAutoCompletion(searchField, cityNames.keySet());

        });

    }

    public void getWeather(String cityNameWithCountryCode) {
        String[] city = cityNameWithCountryCode.split(" / ");

        GeocodingApiClientService geocodingApiClientService = new GeocodingApiClientService(city[0], city[1]);
        geocodingApiClientService.restart();

        geocodingApiClientService.setOnSucceeded(event -> {
            CityCoordinates cityCoordinates = geocodingApiClientService.getValue();
            WeatherApiClientService weatherApiClientService = new WeatherApiClientService(cityCoordinates.getLat(), cityCoordinates.getLon());
            weatherApiClientService.restart();

            weatherApiClientService.setOnSucceeded(event2 -> {
                weatherForecast = weatherApiClientService.getValue();
                updateLabels(cityNameWithCountryCode);

            });
        });
    }

    private void updateLabels(String cityNameWithCountryCode) {
        //actual weather
        cityLabel.setText(cityNameWithCountryCode);
        currentWeatherIcon.setIcon(IconResolver.convertWeatherIcon(weatherForecast.getCurrentWeather().getWeather().get(0).getIcon()));
        currentTempLabel.setText(weatherForecast.getCurrentWeather().getTemp() + "°C");
        currentWeatherLabel.setText(weatherForecast.getCurrentWeather().getWeather().get(0).getDescription());
        currentFeelsLikeLabel.setText("Feels like: " + weatherForecast.getCurrentWeather().getFeels_like().toString() + "°C");
        currenPressLabel.setText("Pressure: " + weatherForecast.getCurrentWeather().getPressure().toString() + "hPa");
        currentWindSpeedLabel.setText("Wind speed: " + weatherForecast.getCurrentWeather().getWind_speed().toString() + "km/h");
        currentDateTimeLabel.setText(DateTime.getActualDateTime());

        //Day 1 weather forcast
        d1DayLabel.setText(DateTime.getDayName(weatherForecast.getDailyWeathers().get(1).getDt()));
        d1DateLabel.setText(DateTime.convertDate(weatherForecast.getDailyWeathers().get(1).getDt()));
        d1WeatherIcon.setIcon(IconResolver.convertWeatherIcon(weatherForecast.getDailyWeathers().get(1).getWeather().get(0).getIcon()));
        d1TempLabel.setText(weatherForecast.getDailyWeathers().get(1).getTemp().getDay().toString() + "°C");
        d1WeatherLabel.setText(weatherForecast.getDailyWeathers().get(1).getWeather().get(0).getMain());

        //Day 2 weather forcast
        d2DayLabel.setText(DateTime.getDayName(weatherForecast.getDailyWeathers().get(2).getDt()));
        d2DateLabel.setText(DateTime.convertDate(weatherForecast.getDailyWeathers().get(2).getDt()));
        d2WeatherIcon.setIcon(IconResolver.convertWeatherIcon(weatherForecast.getDailyWeathers().get(2).getWeather().get(0).getIcon()));
        d2TempLabel.setText(weatherForecast.getDailyWeathers().get(2).getTemp().getDay().toString() + "°C");
        d2WeatherLabel.setText(weatherForecast.getDailyWeathers().get(2).getWeather().get(0).getMain());

        //Day 3 weather forcast
        d3DayLabel.setText(DateTime.getDayName(weatherForecast.getDailyWeathers().get(3).getDt()));
        d3DateLabel.setText(DateTime.convertDate(weatherForecast.getDailyWeathers().get(3).getDt()));
        d3WeatherIcon.setIcon(IconResolver.convertWeatherIcon(weatherForecast.getDailyWeathers().get(3).getWeather().get(0).getIcon()));
        d3TempLabel.setText(weatherForecast.getDailyWeathers().get(3).getTemp().getDay().toString() + "°C");
        d3WeatherLabel.setText(weatherForecast.getDailyWeathers().get(3).getWeather().get(0).getMain());

        //Day 4 weather forcast
        d4DayLabel.setText(DateTime.getDayName(weatherForecast.getDailyWeathers().get(4).getDt()));
        d4DateLabel.setText(DateTime.convertDate(weatherForecast.getDailyWeathers().get(4).getDt()));
        d4WeatherIcon.setIcon(IconResolver.convertWeatherIcon(weatherForecast.getDailyWeathers().get(4).getWeather().get(0).getIcon()));
        d4TempLabel.setText(weatherForecast.getDailyWeathers().get(4).getTemp().getDay().toString() + "°C");
        d4WeatherLabel.setText(weatherForecast.getDailyWeathers().get(4).getWeather().get(0).getMain());

        //Day 5 weather forcast
        d5DayLabel.setText(DateTime.getDayName(weatherForecast.getDailyWeathers().get(5).getDt()));
        d5DateLabel.setText(DateTime.convertDate(weatherForecast.getDailyWeathers().get(5).getDt()));
        d5WeatherIcon.setIcon(IconResolver.convertWeatherIcon(weatherForecast.getDailyWeathers().get(5).getWeather().get(0).getIcon()));
        d5TempLabel.setText(weatherForecast.getDailyWeathers().get(5).getTemp().getDay().toString() + "°C");
        d5WeatherLabel.setText(weatherForecast.getDailyWeathers().get(5).getWeather().get(0).getMain());

    }

    private void getLocation() {
        PublicIpIdentificationService publicIpIdentificationService = new PublicIpIdentificationService();
        publicIpIdentificationService.restart();
        publicIpIdentificationService.setOnSucceeded(event -> {

            IpGeolocationApiClientService ipGeolocationApiClientService = new IpGeolocationApiClientService(publicIpIdentificationService.getValue());
            ipGeolocationApiClientService.restart();
            ipGeolocationApiClientService.setOnSucceeded(event1 -> {
                ipGeolocation = ipGeolocationApiClientService.getValue();
                getWeather(ipGeolocation.getCity() + " / " + ipGeolocation.getCountryCode());
            });
        });
    }

    private void createWindow() {

        viewFactory.showNewWindow();
    }

}

