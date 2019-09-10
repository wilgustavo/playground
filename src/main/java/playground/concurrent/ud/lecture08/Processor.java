package playground.concurrent.ud.lecture08;

import java.util.Scanner;

/**
 * Ejemplo de wait y notify.
 */
public class Processor {

    /**
     * Produce.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running ....");
            wait();
            System.out.println("Resumed.");
        }
    }

    /**
     * Consume.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void consume () throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("Waiting for return key");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();
        }
    }
}
