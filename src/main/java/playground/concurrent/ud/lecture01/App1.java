package playground.concurrent.ud.lecture01;

import java.util.stream.IntStream;

/**
 * Ejemplo de clase  de tipo Thread.
 */
class Runner extends  Thread {
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
 * Programa de ejemplo que ejecuta dos threads.
 */
public class App1 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Runner run1 = new Runner();
        run1.start();

        Runner run2 = new Runner();
        run2.start();

    }
}
