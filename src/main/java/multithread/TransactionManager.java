package multithread;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// Пример с собеса в Цифровой экономике

class Solution {

    public static class Counter {
        private int value;

        Counter() {
        }

        public void increment() {
            value++;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increment();
            }

        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getValue());
    }
}
public class TransactionManager {

    public void processTransaction(Transaction transaction, int sum){
        transaction.getFrom().setSum(transaction.getFrom().getSum() - sum);
        transaction.getTo().setSum(transaction.getTo().getSum() + sum);
        System.out.printf("Transaction from account # %s to account # %s has completed",
                transaction.getFrom().getNumber(),
                transaction.getTo().getNumber());
    }
}
