module org.icesi.animationv2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.animationv2 to javafx.fxml;
    exports org.icesi.animationv2;
}