package org.icesi.animation;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;

    private GraphicsContext graphicsContext;

    private boolean run;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        graphicsContext = canvas.getGraphicsContext2D();
        run = true;

        graphicsContext.setFill(Color.BLUE);

        Platform.runLater(() ->{
            new Thread(()-> {
                int y = 0;

                while (run){
                    try{
                        graphicsContext.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
                        graphicsContext.fillRect(0, y, 50, 50);
                        y++;

                        System.out.println("Controller::Thread >> STEP: "+y);
                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();

        });




    }

    public void setRunning(boolean run){
        this.run = run;
    }
}