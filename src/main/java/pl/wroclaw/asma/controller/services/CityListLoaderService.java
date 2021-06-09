package pl.wroclaw.asma.controller.services;

import com.opencsv.bean.CsvToBeanBuilder;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import pl.wroclaw.asma.model.CityCoordinates;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CityListLoaderService extends Service<List<CityCoordinates>> {

    @Override
    protected Task<List<CityCoordinates>> createTask() {
        return new Task<List<CityCoordinates>>() {
            @Override
            protected List<CityCoordinates> call() throws Exception {
                return loadCityList();
            }
        };
    }

    private List<CityCoordinates> loadCityList() {

        //String fileName = "d:\\programowanie\\WeatherAppFX\\src\\main\\resources\\cities.csv";
        String fileName = "src/main/resources/cities.csv";
        System.out.println(fileName);
        List<CityCoordinates> cityList = new ArrayList<>();

        try {
            cityList = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(CityCoordinates.class)
                    .withSeparator(';')
                    .build()
                    .parse();
            for(CityCoordinates cityCoordinates: cityList) {
                System.out.println(cityCoordinates.getName());
                System.out.println(cityCoordinates.getCountry());
                System.out.println(cityCoordinates.getLon());
                System.out.println(cityCoordinates.getLat());
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cityList;
    }

}
