package pl.wroclaw.asma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/WeatherAppWindow.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        scene.getStylesheets().add("WeatherApp.css");
        stage.setTitle("Simple Weather App");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        //Positioning of application window in the right bottom corner
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) * 0.99;
        double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) * 0.92;
        stage.setX(x);
        stage.setY(y);
    }

    public static void main(String[] args) {
        App.launch();
    }

}