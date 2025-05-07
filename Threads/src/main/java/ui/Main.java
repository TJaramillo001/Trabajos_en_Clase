package ui;

import util.CustomRunnable;
import util.CustomThread;
import util.IFunctional;

public class Main {
    public static void main(String[] args) {

        CustomThread ct = new CustomThread(1000);
        //ct.start();

        CustomRunnable c1 = new CustomRunnable(500);


//        for (int i = 10; i < 20; i++){
//            System.out.println("Main: "+i);
//        }
        Thread t1 = new Thread(c1);

        //t1.start(); //Ejecuta este hilo

        IFunctional f1 = new IFunctional() {
            @Override
            public void unique() {
                System.out.println("FunctionalInterface pre Java8");
            }
        };

        //f1.unique();

        IFunctional f2 = () -> {
            System.out.println("FunctionalInterface post Java8");
        };

        //f2.unique();

        Thread t2 = new Thread(
                // Runnable -> FunctionalInterface -> Lambda Expression
                () ->{
                    System.out.println("Thread lambda");
                }
        );

        //t2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("EXEC >> "+i);
            new Thread(Main::printer).start();
        }
//        Thread t3 = new Thread(Main::printer);
//        t3.start();



    }
    public synchronized static void printer(){
        for (int i = 40; i<50 ; i++){
            System.out.println("Printer: "+i);
        }
    }
}
