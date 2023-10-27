package yndx;

import java.util.Arrays;

public class DP {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 4, 1, 3, 5, 4, 7};
        int[] arr2 = {2};

        System.out.println(Arrays.toString(getLenSubseq(arr1)));
        System.out.println(Arrays.toString(getLenSubseq(arr2)));
    }

    static int[] getLenSubseq(int[] a) {

        if (a.length == 1) {
            return new int[]{1};
        }

        int[] dp = new int[a.length];

        dp[0] = 1;
        int max = 0;

        for (int i = 1; i < a.length; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        return dp;
    }
}
