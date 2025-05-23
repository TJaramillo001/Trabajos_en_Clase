package CounterExercise;

public class Counter {

    private int count;

    private int getCount(){ return count;}

    private synchronized void increment(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count++;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable toDo = () ->{
            for(int i = 0; i<100; i++){
                counter.increment();
                System.out.println("Counter:"+counter.getCount());
            }
        };

        Thread t1 = new Thread(toDo);
        Thread t2 = new Thread(toDo);
        Thread t3 = new Thread(toDo);


        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println("Attempt to join Thread 1");
            t1.join();
            System.out.println("Attempt to join Thread 2");
            t2.join();
            System.out.println("Attempt to join Thread 3");
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
