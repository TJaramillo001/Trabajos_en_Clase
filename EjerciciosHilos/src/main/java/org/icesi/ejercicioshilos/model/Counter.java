package org.icesi.ejercicioshilos.model;

public class Counter implements Runnable{

    private Element subscriber;

    public void setSubscriber(Element subscriber){ this.subscriber = subscriber;}
    @Override
    public void run() {
        while(subscriber.isLive){

        }
    }
}
