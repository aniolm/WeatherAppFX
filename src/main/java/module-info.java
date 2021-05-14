module pl.wroclaw.asma {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.wroclaw.asma to javafx.fxml;
    exports pl.wroclaw.asma;
}