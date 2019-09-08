package playground.concurrent.ud.lecture01;

import java.util.stream.IntStream;

/**
 * Ejemplo de clase que implementa la interface Runnable
 */
class Runner2 implements Runnable {

    @Override
    public void run() {
        IntStream.range(0, 10).forEach(i -> {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

/**
 * Ejemplo de ejecutar 2 threads con clases que implementan la interface Runnable
 */
public class App2 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner2());
        Thread t2 = new Thread(new Runner2());

        t1.start();
        t2.start();
    }

}
