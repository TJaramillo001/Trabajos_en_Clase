package util;

public class CustomRunnable implements Runnable{

    private int timer;

    public CustomRunnable(int timer){
        this.timer = timer;
    }

    @Override
    public void run() {
        for (int i = 30; i<40; i++){
            try{
                System.out.println("CustomRunnable: " + i);
                Thread.sleep(timer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
