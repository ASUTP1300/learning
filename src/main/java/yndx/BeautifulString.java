package yndx;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BeautifulString {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int k = Integer.parseInt(reader.readLine());
        String str = reader.readLine();

        FileWriter writer = new FileWriter("output.txt");
        writer.write(String.valueOf(bString(str, k) ));
        writer.flush();

        System.out.println("Test: 1 " +  bString("abcaz", 2));
        System.out.println("Test: 2 " +  bString("helte", 2));
        System.out.println("Test: 3 " +  bString("halaa", 2));
    }
    static int bString(String str, int k) {
        if (k == str.length()) {
            return k;
        }
        int max = 0;
        for (int i = 97; i <= 122; i++) {
            int t = k;
            int r = 0;
            int d;
            for (int l = 0; l < str.length(); l++) {
                while (r < str.length() &&  t >= 0) {
                    if (i != str.charAt(r)) {
                        t--;
                    }
                    System.out.println( "t " + t + " Буква: " + (char) i + " Буква в строке " + str.charAt(r));

                    r++;

                }
                System.out.println("r = " + r + " l= " + l);
                if (r == str.length() && t  >= 0) {
                    r++;
                }
                    d = r - l - 1;
                System.out.println("d = " + d);
                if (d > max) {
                    max = d;

                }
                if(i != str.charAt(l)){
                    t++;
                }
            }
        }
        return max;
    }
}

