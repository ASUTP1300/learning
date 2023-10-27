package yndx;

public class SubSum {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6};
        int x = 10;
        System.out.println(sumSubAr(a, x));
    }

    //
    //
    //
    static boolean sumSubAr(int[] a, int x){
        int l = 0;
        int r = 0;
        int sum = 0;

        while (l < a.length) {
            if (sum > x) { //0 > 10, 12 > 10; 11 > 10; 9 > 10; 15 > 10, 11 > 10,
                sum -= a[l];// -1, -2, -4
            }
            while(sum < x && r < a.length) { //0 < 10, 1 < 10, 3 < 10, 7 < 10, 12 < 10, 9 < 10, 14 < 10
                sum += a[r]; //+1, +2, + 4, + 5, +6
                r++;//1, 2, 3, 4
            }

            if (sum == x) { // 12 == 10,  14 == 10, 10 == 10
                return true;
            }
            l++;//1, 2
        }
        return false;
    }
}
