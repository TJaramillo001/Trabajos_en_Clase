package org.icesi.animation.actions;

import org.icesi.animation.model.Element;
import org.icesi.animation.model.Element3;

//Publisher
public class Action1 implements Runnable{

    //Sub
    private Element3 subscriber;

    //Add Sub
    public void setElement(Element3 subscriber){
        this.subscriber = subscriber;
    }


    // Notify subscribers
    @Override
    public void run() {
        try{

            subscriber.setX(subscriber.getX() + 2);
            Thread.sleep(subscriber.getTimer());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
