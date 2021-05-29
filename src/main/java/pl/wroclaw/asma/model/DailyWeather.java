package pl.wroclaw.asma.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DailyWeather {

    private Integer pressure;

    private Integer humidity;

    private Integer wind_speed;

    @JsonProperty("temp")
    private Temperature temperature;

    private List<Weather> weather;

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

    public Temperature getTemp() {
        return temperature;
    }

    public void setTemp(Temperature temperature) {
        this.temperature = temperature;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
