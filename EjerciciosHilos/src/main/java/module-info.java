module org.icesi.ejercicioshilos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.ejercicioshilos to javafx.fxml;
    exports org.icesi.ejercicioshilos;
}