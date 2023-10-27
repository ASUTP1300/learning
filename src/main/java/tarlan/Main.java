package tarlan;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    private static int size;
    private static int[] a = new int[10];



    public static void main(String[] args) {



        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }
    // [0, 0, 0, 0, 0] -> 1
    // [1, 0, 0, 0, 0] -> 3
    // [1, 3, 0, 0, 0] -> 2
    static void add(int n) {
        int i = size - 1;
        while (i >= 0) {
            if (a[i] <= n) {
                a[i + 1] = n;
                size++;
                return;
            } else {
                a[i + 1] = a[i];
                i--;
            }
        }
        a[0] = n;
        size++;
    }
}
