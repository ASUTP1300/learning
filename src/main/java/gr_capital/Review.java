package gr_capital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.IntStream;

public class Review {
    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[1];

        AtomicIntegerArray aM = new AtomicIntegerArray(1);


        Thread th1 =  new Thread(() -> IntStream.range(0, 25000).forEach(i -> incrementArrayElement(0, a)));
        Thread th2 =  new Thread(() -> IntStream.range(0, 25000).forEach(i -> incrementArrayElement(0, a)));
        Thread th3 =  new Thread(() -> IntStream.range(0, 25000).forEach(i -> incrementArrayElement(0, a)));

        Thread th4 =  new Thread(() -> IntStream.range(0, 25000).forEach(i -> aM.getAndIncrement(0)));
        Thread th5 =  new Thread(() -> IntStream.range(0, 25000).forEach(i -> aM.getAndIncrement(0)));
        Thread th6 =  new Thread(() -> IntStream.range(0, 25000).forEach(i -> aM.getAndIncrement(0)));





        th1.start();
        th2.start();
        th3.start();

        th4.start();
        th5.start();
        th6.start();

        th1.join();
        th2.join();
        th3.join();

        th4.join();
        th5.join();
        th6.join();

        System.out.println("Typically array : " + Arrays.toString(a));
        System.out.println("Concurrent array : " + aM.get(0));
    }

    synchronized static void incrementArrayElement(int index, int[] a){
        a[index] += 1;
    }


    static void aboutStrings() {
        String str1 = "String1";
        String str2 = "String" + 1;
        String str3 = "String1";

        System.out.println(str1 == str2);
        System.out.println(str1 == (getString() + 1));
        System.out.println(str1 == str3);
    }

    static String getString() {
        return "String";
    }


}

class Int {
    private int value;

    public Int(int value) {
        this.value = value;
    }

    private static ConcurrentSkipListSet<Int> curList = new ConcurrentSkipListSet<>();
    static private Int[] cache = new Int[256];

    static {
        IntStream.rangeClosed(-128, 127).forEach(n -> {
            cache[n + 128] = new Int(n);
            System.out.println("Cash has received Int value " + n);
        });
        System.out.println(Arrays.toString(cache));
    }

    static Int getFromCache(int value) {
        Int target = cache[value + 128];
        System.out.printf("Int %s was gotten \n", target);
        return target;
    }

    public static Int valueOf(int value) {
        if (value >= -128 && value <= 127) {
            return getFromCache(value);
        } else {
            return new Int(value);
        }
    }

    @Override
    public String toString() {
        return "Int{" +
                "value=" + value +
                '}';
    }

}


