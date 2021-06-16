package pl.wroclaw.asma.controller;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import pl.wroclaw.asma.controller.services.CityListLoaderService;
import pl.wroclaw.asma.model.CityCoordinates;
import pl.wroclaw.asma.model.IpGeolocation;
import pl.wroclaw.asma.model.WeatherForecast;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.*;

public class WeatherAppController implements Initializable {

    private IpGeolocation ipGeolocation;
    private CityCoordinates cityCoordinates;
    private WeatherForecast weatherForecast;
    private Map<String, String> cityNames = new HashMap<String, String>();

    @FXML
    private TextField firstSearchField;

    @FXML
    private Label firstCityLabel;

    @FXML
    private WeatherIconView firstCurrentWeatherIcon;

    @FXML
    private Label firstCurrentTempLabel;

    @FXML
    private Label firstCurrentWeatherLabel;

    @FXML
    private Label firstCurrentFeelsLikeLabel;

    @FXML
    private Label firstCurrenPressLabel;

    @FXML
    private Label firstCurrentWindSpeedLabel;

    @FXML
    private Label firstCurrentDateTimeLabel;

    @FXML
    private Label firstD1DayLabel;

    @FXML
    private Label firstD1DateLabel;

    @FXML
    private WeatherIconView firstD1WeatherIcon;

    @FXML
    private Label firstD1TempLabel;

    @FXML
    private Label firstD1WeatherLabel;

    @FXML
    private Label firstD2DayLabel;

    @FXML
    private Label firstD2DateLabel;

    @FXML
    private WeatherIconView firstD2WeatherIcon;

    @FXML
    private Label firstD2TempLabel;

    @FXML
    private Label firstD2WeatherLabel;

    @FXML
    private Label firstD3DayLabel;

    @FXML
    private Label firstD3DateLabel;

    @FXML
    private WeatherIconView firstD3WeatherIcon;

    @FXML
    private Label firstD3TempLabel;

    @FXML
    private Label firstD3WeatherLabel;

    @FXML
    private Label firstD4DayLabel;

    @FXML
    private Label firstD4DateLabel;

    @FXML
    private WeatherIconView firstD4WeatherIcon;

    @FXML
    private Label firstD4TempLabel;

    @FXML
    private Label firstD4WeatherLabel;

    @FXML
    private Label firstD5DayLabel;

    @FXML
    private Label firstD5DateLabel;

    @FXML
    private WeatherIconView firstD5WeatherIcon;

    @FXML
    private Label firstD5TempLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setUpSearchTextField();
        printCityNames();
    }


    public void setUpSearchTextField() {

        CityListLoaderService cityListLoaderService = new CityListLoaderService();
        cityListLoaderService.start();
        cityListLoaderService.setOnSucceeded(event -> {
            cityNames = cityListLoaderService.getValue();
            TextFields.bindAutoCompletion(firstSearchField, cityNames.keySet());
        });

    }

    public void printCityNames() {
        System.out.println(cityNames.keySet());
    }

}

