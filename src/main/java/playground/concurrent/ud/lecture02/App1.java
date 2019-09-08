package playground.concurrent.ud.lecture02;

import java.util.Scanner;

/**
 * Ejemplo de uso de "volatile" para prevenir que cada thread tenga una "cache" propia de la variable
 */
class Processor extends  Thread {

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Shutdown.
     */
    public void shutdown() {
        running = false;
    }
}

/**
 * The type App 1.
 */
public class App1 {

    /**
     * Ejemplo de programa con una variable "volatile" compartida entre threads
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press return to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        proc1.shutdown();
    }
}
