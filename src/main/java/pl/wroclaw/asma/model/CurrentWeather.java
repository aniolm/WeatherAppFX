package pl.wroclaw.asma.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CurrentWeather {

    private Integer temp;

    private Integer feels_like;

    private Integer pressure;

    private Integer humidity;

    private Integer wind_speed;

    private List<Weather> weather;

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Integer feels_like) {
        this.feels_like = feels_like;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Integer wind_speed) {
        this.wind_speed = wind_speed;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
