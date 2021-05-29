package pl.wroclaw.asma.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherForecast {

    private Double lat;

    private Double lon;

    private String timezone;

    private Integer timezone_offset;

    @JsonProperty("current")
    private CurrentWeather currentWeather;

    @JsonProperty("daily")
    private List<DailyWeather> dailyWeathers;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(Integer timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public List<DailyWeather> getDailyWeathers() {
        return dailyWeathers;
    }

    public void setDailyWeathers(List<DailyWeather> dailyWeathers) {
        this.dailyWeathers = dailyWeathers;
    }

    /*
    @SuppressWarnings("unchecked")
    @JsonProperty("current")
    private void unpackNested(Map<String, Object> current) {

        this.temp = (Double) current.get("temp");
        this.feels_like = (Double) current.get("feels_like");
        this.pressure = (Integer) current.get("pressure");
        this.humidity = (Integer) current.get("humidity");
        this.wind_speed = (Integer) current.get("wind_speed");
        this.weather = (Weather) current.get("weather");

        //Map<String,String> weather = (Map<String, String>) current.get("weather");
        //this.main = weather.get("main");
        //this.description = weather.get("description");
        //this.icon = weather.get("icon");
    }
     */
}