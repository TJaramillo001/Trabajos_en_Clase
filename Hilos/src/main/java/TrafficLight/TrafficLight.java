package TrafficLight;

public class TrafficLight extends Thread{
    private int count = 0;
    public static void main(String[] args) {
        TrafficLight tl = new TrafficLight();
        Thread traffic = new Thread(tl);
        traffic.start();
    }

    @Override
    public void run(){
        while(count!=10){
            try{
                System.out.println("RED");
                Thread.sleep(2000);
                System.out.println("GREEN");
                Thread.sleep(2000);
                System.out.println("YELLOW");
                Thread.sleep(2000);
                System.out.println("Exec >> "+(count+1));
                count++;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
