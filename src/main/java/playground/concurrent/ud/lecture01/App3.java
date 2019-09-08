package playground.concurrent.ud.lecture01;


import java.util.stream.IntStream;

/**
 * Ejemplo de crear un thread con una clase anonima que implemente la interface Runnable
 */
public class App3 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> IntStream.range(0, 10).forEach(i -> {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        t1.start();
    }
}
