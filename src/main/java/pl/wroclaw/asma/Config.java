package pl.wroclaw.asma;

public class Config {
    private static String citiesFileName = "src/main/resources/cities.csv";
    private static String openWeatherMapApiKey = "99906e25ff6d624254c547ed44f5914f";
    private static Integer ipGeoLocationAccountId = 560122;
    private static String ipGeolocationLicenseKey = "EiQfAeZkqu5E6NuF";
    private static String ipGeolocationHost = "geolite.info";

    public static String getCitiesFileName() {
        return citiesFileName;
    }

    public static String getOpenWeatherMapApiKey() {
        return openWeatherMapApiKey;
    }

    public static Integer getIpGeoLocationAccountId() {
        return ipGeoLocationAccountId;
    }

    public static String getIpGeolocationLicenseKey() {
        return ipGeolocationLicenseKey;
    }

    public static String getIpGeolocationHost() {
        return ipGeolocationHost;
    }
}
