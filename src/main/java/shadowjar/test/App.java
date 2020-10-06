/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package shadowjar.test;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {

        }
        int memory = 1234;
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("scheduling asynchronous job ");
            executor.schedule(() -> {
                sleepAndPrint(10000, memory);
            }, 10, TimeUnit.SECONDS);
            System.out.println("asynchronous job scheduled");
            sleepAndPrint(1000, memory);
        }));
    }

    private static void sleepAndPrint(long delay, int output) {
        try {
            System.out.println("thread=" + Thread.currentThread().getName() + " Before sleep: " + output);
            Thread.sleep(delay);
            System.out.println("thread=" + Thread.currentThread().getName() + " After sleep: " + output);
        } catch(InterruptedException ex) {

        }
    }
}
