package integrity.multithread;

public class Main {
    public static void main(String[] args) {
        int val = 0;
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.val = val;
        myThread2.val = val;

        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);


        thread1.start();
        thread2.start();

    }
}


class MyThread implements Runnable {

    int val;

    @Override
    public void run() {
          increment();
    }

    synchronized void increment(){
        val++;
        System.out.println("Val was incremented by " + Thread.currentThread().getName() + " Current value of Val is " + val);
        try {
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
