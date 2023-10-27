package fwwd;

import java.util.stream.IntStream;

public class Synchronized {
    static int value;

    public static void incrementValue() {
        IntStream.range(0, 100).forEach(n -> value++);
        System.out.println(value);
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = Synchronized::incrementValue;

        Thread th1 = new Thread(r);
        Thread th2 = new Thread(r);

        th1.start();
        th2.start();

//        th1.join();
//        th2.join();
//
//        System.out.println(Synchronized.value);
    }
}
