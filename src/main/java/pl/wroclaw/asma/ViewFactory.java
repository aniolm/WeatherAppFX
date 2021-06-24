package pl.wroclaw.asma;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pl.wroclaw.asma.controller.WeatherAppController;

import java.io.IOException;
import java.net.URL;

public class ViewFactory {

    public void showNewWindow(){
        WeatherAppController weatherAppController = new WeatherAppController("view/WeatherAppWindow.fxml", this);
        initializeStage(weatherAppController);

    }

    public void initializeStage(WeatherAppController weatherAppController){
        URL urlWindow = getClass().getResource(weatherAppController.getFxmlName());
        FXMLLoader fxmlLoader = new FXMLLoader(urlWindow);
        fxmlLoader.setController(weatherAppController);
        Parent root;
        try {
            root = fxmlLoader.load();
        }catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add("WeatherApp.css");

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Simple Weather App");
        stage.setResizable(false);
        stage.show();
        //Positioning of application window in the right bottom corner
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) * 0.99;
        double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) * 0.92;
        stage.setX(x);
        stage.setY(y);


    }
}
