package org.icesi.ejercicioshilos;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import org.icesi.ejercicioshilos.model.Counter;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private boolean run;


    @FXML
    private Canvas canvas;

    private Rectangle r1;
    private Rectangle r2;
    private Rectangle r3;

    private GraphicsContext graphicsContext;


    public void setRun(boolean run) {
        this.run = run;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        graphicsContext = canvas.getGraphicsContext2D();
        run = true;

        Counter count = new Counter();
    }
}