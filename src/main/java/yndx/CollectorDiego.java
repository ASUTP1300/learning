package yndx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CollectorDiego {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        reader.readLine();
        int[] diegoCards = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).distinct().sorted().mapToInt(x -> x).toArray();

        reader.readLine();
        int[] friendsCards = Arrays.stream(reader.readLine().split(" ")).parallel().map(Integer::parseInt).mapToInt(x -> x).toArray();

        FileWriter writer = new FileWriter("output.txt");

        for (int friendsCard : friendsCards) {
            writer.write(bSort(diegoCards, friendsCard) + "\n");
        }
        writer.flush();
    }

    static int bSort(int[] ar, int n) {
        int l = 0;
        int r = ar.length - 1;
        int p = 0;
        while (r >= l) {
            p = l + (r - l) / 2;
            if (n == ar[p]) {
                return p;
            }
            if (n > ar[p]) {
                l = p + 1;
            }
            if (n < ar[p]) {
                r = p - 1;
            }
        }
        return l + (r - l) / 2;
    }
}
