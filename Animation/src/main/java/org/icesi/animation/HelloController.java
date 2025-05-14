package org.icesi.animation;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import org.icesi.animation.actions.Action1;
import org.icesi.animation.model.Element;
import org.icesi.animation.model.Element2;
import org.icesi.animation.model.Element3;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;

    private Rectangle r1;
    private Rectangle r2;

    private Element e1;
    private Element2 e2;
    private Element3 e3;




    private GraphicsContext graphicsContext;

    private boolean run;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        graphicsContext = canvas.getGraphicsContext2D();
        run = true;

        e1 = new Element(canvas, Color.BLUE, 100, 250, 0, 50, 50,
                ()->{
                    System.out.println("Hello");
                });
        e2 = new Element2(canvas, Color.RED, 250, 0, 0, 50, 50);

        Action1 a1 = new Action1();

        e3 = new Element3(canvas, Color.GREEN, 500, 0, 0, 50, 50, a1);

        a1.setElement(e3);

        e1.start();

        new Thread(e2).start();

        e3.start();


        Platform.runLater(() ->{
            new Thread(()-> {
                int y = 0;

                while (run){
                    try{
                        graphicsContext.clearRect(0,0, canvas.getWidth(), canvas.getHeight());

//                        graphicsContext.setFill(Color.BLUE);
//                        graphicsContext.fillRect(0, y, r1.getWidth(), r1.getHeight());
//                        y++;
//
//                        graphicsContext.setFill(Color.RED);
//                        graphicsContext.fillRect(y, 0, r2.getWidth(), r2.getHeight());

                        e1.paint();
                        e2.paint();
                        e3.paint();

                        double distance = Math.sqrt(
                                Math.pow(e1.getX()-e2.getX(), 2) + Math.pow(e1.getY() - e2.getY(), 2)
                        );

                        if(distance<=51){
                            graphicsContext.setFill(Color.CYAN);
                            graphicsContext.fillRect(e2.getX()+50, e2.getY()-25, 25, 25);

                            e1.setLive(false);
                            e2.setLive(false);
                        }

                        System.out.println("Distance::Thread >> "+distance);
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