package algorithm;

import java.util.Arrays;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        for(int i = 1; i < 100; i++){
            if(checkNumber(i)){
                System.out.println("Простое чилос:\t" + i);
            }
        }

    }

//    static int getMedian(int a1, int a2, int a3){
//        if(a1 > a2){
//            if(a2 < a3){
//                return a2;
//            } else {
//                return a3;
//            }
//        } else
//    }


    static int findPivot(int[] a){
        int pivot = 0;
        int l = 0;
        int r = a.length - 1;
        int m = 0;
        while (r >= l){
            m = (l + r) / 2;
            if(a[m] <= a[m - 1] && a[m]<= a[m + 1]){
                return a[m];
            }
            if(a[m] < a[m + 1]){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    static int[] rotateArray(int[] a, int pivot){
        if(pivot > a.length - 1 || pivot < 0){
            throw new RuntimeException("Ошибка, некорректное значение pivot");
        }
        int w = 0;
        for(int i = 0; i < pivot; i++){
            w = a[i];
            a[i] = a[pivot + i];
            a[pivot + i + 1] = w;
        }
        return a;
    }

   static int bSearch(int[] a, int target){
        long start = System.currentTimeMillis();
        int l = 0;
        int r = a.length - 1;

        while (r >= l){
            int m = (r + l)/2;
            System.out.printf("Значение m: %s\n", m);
            if(target == a[m]){
                long stop = System.currentTimeMillis();
                System.out.println("Время выполнения " + (stop - start));
                return m;
            }
            if(target < a[m]){
               r = m - 1;
            }
            if(target > a[m]){
                l = m + 1;
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (stop - start));
        return -1;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int[] ints : matrix) {
            if (target <= ints[ints.length - 1]) {
                int search = bSearch(ints, target);
                return search != -1;
            }
        }
        return false;
    }


   static boolean checkNumber(int n){
        if(n == 2){
            return true;
        } else {
            for(int i = 2; i < n - 1; i++){
                if(n%i == 0){
                    return false;
                }

            }
        }
        return true;
   }

}


