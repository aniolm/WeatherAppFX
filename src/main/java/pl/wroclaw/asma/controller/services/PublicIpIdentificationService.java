package pl.wroclaw.asma.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class PublicIpIdentificationService extends Service<String> {

    @Override
    protected Task<String> createTask() {
        return new Task<String>() {

            @Override
            protected String call() throws Exception {
                return identifyIpAddress();
            }
        };
    }

    private String identifyIpAddress() {
        String ipAddress = "";
        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            ipAddress = in.readLine();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ipAddress;
    }
}
