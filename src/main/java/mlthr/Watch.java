package mlthr;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Watch {

    volatile int  i = 1;



    public static void main(String[] args) throws InterruptedException {

        Watch watch = new Watch();
        Runnable r = () -> IntStream.rangeClosed(0, 100).forEach( n -> watch.i++);

        Thread th1 =  new Thread(r);
        Thread th2 =  new Thread(r);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println("i is " + watch.i);

    }
}



