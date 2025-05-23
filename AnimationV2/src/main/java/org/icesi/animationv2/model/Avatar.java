package org.icesi.animationv2.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Avatar extends Thread{
    private Canvas canvas;
    private GraphicsContext gc;

    private double x;
    private double y; //coords
    private double w; //width height
    private double h;

    //variables de control de movimiento
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    public Avatar(Canvas canvas, double x, double y, double w, double h){
        this.canvas = canvas;
        this.gc=canvas.getGraphicsContext2D();

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void paint(){
        onMove();
        gc.setFill(Color.RED);
        gc.fillRect(x, y, w, h);
    }

    @Override
    public void run(){
        while(true){
            try {
                System.out.println("AVATAR::X >>" + x);
                System.out.println("AVATAR ::Y >>" + y);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onMove(){
        if(up){
            y -= 5;
        } else if(down){
            y += 5;
        } else if (left) {
            x -= 5;
        } else if (right) {
            x += 5;
        }
    }

    public void setOnKeyPressed(KeyEvent event){
        switch (event.getCode()){
            case W -> {up = true;}
            case S -> {down = true;}
            case A -> {left = true;}
            case D -> {right = true;}

        }
    }
    public void setOnKeyReleased(KeyEvent event){
        switch (event.getCode()){
            case W -> {up = false;}
            case S -> {down = false;}
            case A -> {left = false;}
            case D -> {right = false;}

        }
    }
}
