package pl.wroclaw.asma.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import pl.wroclaw.asma.Config;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

public class CityListLoaderService extends Service<HashMap<String, String>> {

    @Override
    protected Task<HashMap<String, String>> createTask() {
        return new Task<HashMap<String, String>>() {
            @Override
            protected HashMap<String, String>  call() throws Exception {
                return loadCityList();
            }
        };
    }

    private HashMap<String, String> loadCityList() {

        String fileName = Config.getCitiesFileName();
        HashMap cityList = new HashMap<String, String>();

        try {

            Reader in = new FileReader( fileName );

            CSVParser parser = new CSVParser( in, CSVFormat.DEFAULT.withDelimiter(';') );
            List<CSVRecord> csvCityList = parser.getRecords();

            for( CSVRecord row : csvCityList ){
                cityList.put(row.get(0) + " / "+ row.get(3),row.get(1) + ", "+ row.get(2));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityList;
    }
}
