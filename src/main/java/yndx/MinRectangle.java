package yndx;

import jdk.jshell.execution.Util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class MinRectangle {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        Writer writer = new FileWriter("output.txt");

        int l = scanner.nextInt();
        int[] ax = new int[l];
        int[] ay = new int[l];
        int i = 0;

        while (scanner.hasNext()) {
            ax[i] = scanner.nextInt();
            ay[i] = scanner.nextInt();
            i++;
        }
        qSort(ax, 0, ax.length - 1);
//        qSort(ay, 0, ay.length - 1);

        String res = ax[0] + " " + ay[0] + " " + ax[ax.length - 1] + " " + ay[ay.length - 1];
        writer.write(res);
        writer.flush();

        System.out.println("ax À ÈÃÐÝÊ ÈÊÑ " + Arrays.toString(ax));
        System.out.println("ay " + Arrays.toString(ay));

        System.out.println(res);

    }

    static void qSort(int[] a, int l, int r){
        if (r > l) {
            int p = partition(a, l, r);
            qSort(a, l, p - 1);
            qSort(a, p, r);
        }
    }

    static int partition(int[] a, int l, int r) {
        int p = (r + l) / 2 ;
        System.out.println(a[p]);

        int b = 0;
        while (r >= l) {
            while (a[l] < a[p]) {
                l++;
            }
            while (a[p] < a[r]) {
                r--;
            }
            if (r >= l){
                  b = a[l];
                  a[l] = a[r];
                  a[r] = b;
                  l++;
                  r--;
                }
        }
        System.out.println("l= " + l + " - " + "a[l] = " + a[l]);
        return l;
    }
}
