module WeatherAppFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires geoip2;

    opens pl.wroclaw.asma to javafx.fxml;
    opens pl.wroclaw.asma.controller;
    exports pl.wroclaw.asma;
    exports pl.wroclaw.asma.controller;
    exports pl.wroclaw.asma.model;
}
