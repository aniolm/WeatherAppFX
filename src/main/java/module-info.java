module pl.wroclaw.asma {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.wroclaw.asma to javafx.fxml;
    opens pl.wroclaw.asma.controller;
    exports pl.wroclaw.asma;
}