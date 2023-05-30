package vk;

import java.util.stream.IntStream;
import java.util.Arrays;

public class FindDistanceArray {
    public static void main(String[] args) {

        double d = Math.abs(-4 - 4);
//        System.out.println(d);
//        arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2 [-4,-3,6,10,20,30] [1,4,2,3]
        int[] arr1 = new int[]{1,4,2,3};
        int[] arr2 = new int[]{1,4,2,3};

        System.out.println(Arrays.equals(arr1, arr2));


//        System.out.println(findTheDistanceValue(arr1, arr2, 3));
    }
    static public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

      long count =  IntStream.range(0, arr1.length)
                    .filter(i -> (IntStream.range(0, arr2.length).filter(j -> Math.abs(arr1[i] - arr2[j]) > d).count()) == arr2.length)
                        .count();
        System.out.println(count);

        return (int) count;
    }
}
