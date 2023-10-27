package yndx;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();

        OutputStreamWriter osr = new OutputStreamWriter(System.out);
        System.out.println(countN(s, n));
    }

    static int countN(int s, int n) {

        int i = s;
        while (n >= 0) {
            if (i > n) {
                return n;
            }
            n -= i;
            i--;
            if (i == 0) {
                i = s;
            }
        }
        return n;
    }
}
