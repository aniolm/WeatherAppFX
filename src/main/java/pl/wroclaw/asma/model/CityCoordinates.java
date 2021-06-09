package pl.wroclaw.asma.model;

import com.opencsv.bean.CsvBindByName;

public class CityCoordinates {

    @CsvBindByName(column = "city_ascii")
    private String name;

    @CsvBindByName(column = "lat")
    private String lat;

    @CsvBindByName(column = "lng")
    private String lon;

    @CsvBindByName(column = "iso2")
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String latitude) {
        this.lat = latitude;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

}
