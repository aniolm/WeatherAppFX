package pl.wroclaw.asma;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.wroclaw.asma.controller.WeatherAppController;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        ViewFactory viewFactory = new ViewFactory();
        WeatherAppController weatherAppController = new WeatherAppController("view/WeatherAppWindow.fxml", viewFactory);
        viewFactory.initializeStage(weatherAppController);
    }

    public static void main(String[] args) {
        App.launch();
    }

}