package pl.wroclaw.asma.controller.services;

import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import pl.wroclaw.asma.model.IpGeolocation;
import com.maxmind.geoip2.WebServiceClient;

import java.net.InetAddress;

public class IpGeolocationApiClientService extends Service<IpGeolocation> {

    private String ip;

    public IpGeolocationApiClientService(String ip) {
        this.ip = ip;
    }

    @Override
    protected Task<IpGeolocation> createTask() {
        return new Task<IpGeolocation>() {
            @Override
            protected IpGeolocation call() throws Exception {
                return getIpGeolocation();
            }
        };
    }



    private IpGeolocation getIpGeolocation() {
        IpGeolocation ipGeolocation = new IpGeolocation();

        try (WebServiceClient client = new WebServiceClient.Builder(560122, "EiQfAeZkqu5E6NuF").host("geolite.info")
                .build()) {

            InetAddress ipAddress = InetAddress.getByName(ip);

            CountryResponse countryResponse = client.country(ipAddress);
            Country country = countryResponse.getCountry();
            ipGeolocation.setCountryCode(country.getIsoCode());

            CityResponse cityResponse = client.city(ipAddress);
            City city = cityResponse.getCity();
            ipGeolocation.setCity(city.getName());

        } catch (Exception e){
            e.printStackTrace();
        }
        return ipGeolocation;

    }
}
