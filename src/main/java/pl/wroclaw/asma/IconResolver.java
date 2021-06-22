package pl.wroclaw.asma;

import de.jensd.fx.glyphs.weathericons.WeatherIcon;

import java.util.HashMap;
import java.util.Map;

public class IconResolver {
    public static WeatherIcon convertWeatherIcon(String iconNumber){
        Map<String, WeatherIcon> icons = new HashMap<String, WeatherIcon>();
        icons.put("01d" , WeatherIcon.FORECAST_IO_CLEAR_DAY);
        icons.put("01n" , WeatherIcon.FORECAST_IO_CLEAR_NIGHT);
        icons.put("02d" , WeatherIcon.FORECAST_IO_PARTLY_CLOUDY_DAY);
        icons.put("02n" , WeatherIcon.FORECAST_IO_PARTLY_CLOUDY_NIGHT);
        icons.put("03d" , WeatherIcon.CLOUD);
        icons.put("03n" , WeatherIcon.CLOUD);
        icons.put("04d" , WeatherIcon.FORECAST_IO_CLOUDY);
        icons.put("04n" , WeatherIcon.FORECAST_IO_CLOUDY);
        icons.put("09d" , WeatherIcon.DAY_SHOWERS);
        icons.put("09n" , WeatherIcon.NIGHT_ALT_SHOWERS);
        icons.put("10d" , WeatherIcon.FORECAST_IO_RAIN);
        icons.put("10n" , WeatherIcon.FORECAST_IO_RAIN);
        icons.put("11d" , WeatherIcon.FORECAST_IO_THUNDERSTORM);
        icons.put("11n" , WeatherIcon.FORECAST_IO_THUNDERSTORM);
        icons.put("13d" , WeatherIcon.FORECAST_IO_SNOW);
        icons.put("13n" , WeatherIcon.FORECAST_IO_SNOW);
        icons.put("50d" , WeatherIcon.FORECAST_IO_FOG);
        icons.put("50d" , WeatherIcon.FORECAST_IO_FOG);

        return icons.get(iconNumber);
    }
}
