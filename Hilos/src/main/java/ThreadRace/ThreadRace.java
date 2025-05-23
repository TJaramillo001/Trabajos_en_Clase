package ThreadRace;

import java.util.Random;

public class ThreadRace extends Thread{

    private int r1Pos;
    private int r2Pos;
    private int r3Pos;

    public ThreadRace() {
        r1Pos=0;
        r2Pos=0;
        r3Pos=0;
    }

    public static void main(String[] args) {
        ThreadRace tr = new ThreadRace();
        Random rand = new Random();


        Thread runner1 = new Thread(tr);
        Thread runner2 = new Thread(tr);
        Thread runner3 = new Thread(tr);

        runner1.start();
        runner2.start();
        runner3.start();
    }

    @Override
    public void run(){
        while(r1Pos <= 100 && r2Pos<=100 && r3Pos <=100){
            try {
                Thread.sleep(2400);
                r1Pos += (int)(Math.random()*5)+1;
                Thread.sleep(50);
                r2Pos += (int)(Math.random()*5)+1;
                Thread.sleep(50);
                r3Pos += (int)(Math.random()*5)+1;

                Thread.sleep(50);

                System.out.println("R1 position "+r1Pos);
                System.out.println("R2 position "+r2Pos);
                System.out.println("R3 position "+r3Pos);
                System.out.println("================================");

                if (r1Pos>=100){
                    System.out.println("Runner 1 Wins!");
                } else if (r2Pos >= 100) {
                    System.out.println("Runner 2 Wins!");
                } else if (r3Pos >=100) {
                    System.out.println("Runner 3 Wins!");
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }







        }
    }
}
