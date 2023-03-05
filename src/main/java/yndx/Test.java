package yndx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int row = Integer.parseInt(br.readLine());
        int site = Integer.parseInt(br.readLine());

        int row_num = 0;
        int num = 1;
        int v = 1;
        while (num <= n) {
            System.out.print("Ряд " + ++row_num + ": ");
            for (int i = 1; i <= 2; i++) {
                if (v > k) {
                    v = 1;
                }
                if (num > n) {
                    break;
                }
                System.out.print(v + " ");
                num++;
                v++;
            }
            System.out.println();
        }

        FileWriter fw = new FileWriter("output.txt");
        fw.write(suggest(n, k, row, site));
        fw.flush();

    }

    static String suggest(int n, int k, int row, int site) {
        int target1 = (row * 2) - site % 2 - k;
        int target2 = (row * 2) - site % 2 + k;
        int nTarget = 0;

        if (target1 > 0 && target2 <= n) {
            nTarget = row - target1 / 2 - target1 % 2 < target2 / 2 + target2 % 2 - row ? target1 : target2;
        } else {
            if (target1 > 0) {
                nTarget = target1;
            } else if (target2 <= n) {
                nTarget = target2;
            } else {
                return "-1";
            }
        }

        String res = nTarget / 2 + nTarget % 2 + "";
        String resSite = k % 2 == 0 ? site + "" : site % 2 == 0 ? "1" : "2";
        return res + " " + resSite;
    }
}
