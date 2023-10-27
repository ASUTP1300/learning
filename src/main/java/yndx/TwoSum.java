package yndx;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class TwoSum {
    public static void main(String[] args) {
        int[] a1 = {-1, 0, 1, 2, 6};


        int[] arTest = IntStream.rangeClosed(0, 25_000_000).toArray();

        int x = 24_500_000;

        System.out.println("Test 1: " + twoSumLong(arTest, x));
        System.out.println("Test 2: " + twoSumLong(arTest, x));

        duration(() -> twoSum(arTest, x));
        duration(() -> twoSumLong(arTest, x));
    }


    static void duration(Supplier<Boolean> supplier) {
        long start = System.currentTimeMillis();
        supplier.get();
        long duration = System.currentTimeMillis() - start;
        System.out.printf("Duration is %d\n", duration);
    }

    static boolean twoSum(int[] a, int x) {
        int i = 0;
        int j = a.length - 1;
        int s = 0;

        while (i < a.length && j > 0) {
            s = a[i] + a[j];

            if (s == x) {
                return true;
            }

            if (s > x) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    static boolean twoSumLong(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == x) {
                    return true;
                }
            }
        }
        return false;
    }
}
