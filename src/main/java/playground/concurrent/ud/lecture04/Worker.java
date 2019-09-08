package playground.concurrent.ud.lecture04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase de ejemplo para mostrar el uso de bloques de código syncronized y utilizando objetos como semaforos.
 */
public class Worker {

    private Random random = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    /**
     * Stage one.
     */
    public void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list1.add(random.nextInt(100));
        }
    }

    /**
     * Stage two.
     */
    public void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list2.add(random.nextInt(100));
        }
    }

    /**
     * Process.
     */
    public void process () {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    /**
     * Main.
     */
    public  void main() {
        System.out.println("Starting ");

        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> process());
        Thread t2 = new Thread(() -> process());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Time take:" + (end - start));
        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());
    }
}
