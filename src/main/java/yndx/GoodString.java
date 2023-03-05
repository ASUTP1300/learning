package yndx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class GoodString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Writer writer = new FileWriter("output.txt");

        int n = Integer.parseInt(br.readLine());

        int[] ar = new int[n];
        int i = 0;
        while (i < n) {
            ar[i] = Integer.parseInt(br.readLine());
            i++;
        }

        int buf = 0;
        long d = 0;
        for (int j = 0; j < ar.length - 1; j++) {
            d += ar[j] >= ar[j + 1] ? ar[j + 1] : ar[j];


            System.out.println("a[j]: " + ar[j] + " a[j + 1]: " + ar[j + 1]);

        }
        writer.write(String.valueOf(d));
        writer.flush();
        System.out.println("d " + d);
        System.out.println(Arrays.toString(ar));
        System.out.println(Integer.MAX_VALUE);
    }

}
