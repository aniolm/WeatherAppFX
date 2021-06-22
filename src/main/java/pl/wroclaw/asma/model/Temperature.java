package pl.wroclaw.asma.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
    //@JsonProperty("day")
    private Integer day;

    //@JsonProperty("min")
    private Integer min;

    //@JsonProperty("max")
    private Integer max;

   // @JsonProperty("night")
    private Integer night;

    //@JsonProperty("eve")
    private Integer eve;

    //@JsonProperty("morn")
    private Integer morn;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getNight() {
        return night;
    }

    public void setNight(Integer night) {
        this.night = night;
    }

    public Integer getEve() {
        return eve;
    }

    public void setEve(Integer eve) {
        this.eve = eve;
    }

    public Integer getMorn() {
        return morn;
    }

    public void setMorn(Integer morn) {
        this.morn = morn;
    }
}
