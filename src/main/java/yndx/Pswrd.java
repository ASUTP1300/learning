package yndx;

import java.util.Arrays;
import java.util.Scanner;

public class Pswrd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int[] nums = Arrays.stream(s1.split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();

        int n = nums[0];
        int k = nums[1];

        String pswrd = sc.next();


        System.out.println(getLen(pswrd, k));

    }

    static int getLen(String pswrd, int k) {
        if (k >= pswrd.length()) {
            return 0;
        }
        int res = pswrd.codePoints().boxed().distinct().toArray().length - k;
        return res > 0 ? res : 1;
    }
}
