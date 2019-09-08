package playground.concurrent.ud.lecture03;

import java.util.stream.IntStream;


/**
 * Ejemplo de uso de un metodo synchronized para compartir datos entre varios threads
 */
public class App1 {

    private int count = 0;

    /**
     * Incrementa el contador.
     * Este metodo está sincronizado porque accede a un dato compartido
     */
    public synchronized void increment() {
        count++;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        App1 app1 = new App1();
        app1.doWork();
    }

    /**
     * Do work.
     */
    public void doWork() {
        Thread t1 = new Thread(() -> IntStream.range(0, 10000).forEach(i -> {
            increment();
        }));

        Thread t2 = new Thread(() -> IntStream.range(0, 10000).forEach(i -> {
            increment();
        }));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count is " + count);
    }
}
