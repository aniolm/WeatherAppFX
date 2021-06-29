package pl.wroclaw.asma;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showNewWindow();
    }

    public static void main(String[] args) {
        App.launch();
    }

}