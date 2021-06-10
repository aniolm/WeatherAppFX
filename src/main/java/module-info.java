module WeatherAppFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires geoip2;
    requires opencsv;
    //requires commons.beanutils;
    //requires commons.collections;
    //requires commons.logging;
    //requires org.apache.commons.collections4;
    //requires org.apache.commons.lang3;
    //requires org.apache.commons.text;
    requires org.controlsfx.controls;
    requires de.jensd.fx.glyphs.weathericons;

    opens pl.wroclaw.asma;
    opens pl.wroclaw.asma.controller;
    opens pl.wroclaw.asma.model;
    opens pl.wroclaw.asma.controller.services;


    exports pl.wroclaw.asma;
    exports pl.wroclaw.asma.controller;
    exports pl.wroclaw.asma.model;
    exports pl.wroclaw.asma.controller.services;



}