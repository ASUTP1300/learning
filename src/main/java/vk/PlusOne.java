package vk;


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlusOne {
    public static void main(String[] args) {
        int[] test1Nums = new int[]{4, 3, 2, 1};
        int[] test2Nums = new int[]{9,8,7,6,5,4,3,2,1,9};
        int[] test3Nums = new int[]{6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        int[] test4Nums = new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        int[] test5Nums = new int[]{1};
        System.out.println("1 - " + Arrays.toString(plusOne2(test1Nums)));
        System.out.println("2 - " + Arrays.toString(plusOne2(test2Nums)));
        System.out.println("3 - " + Arrays.toString(plusOne2(test3Nums)));
        System.out.println("4 - " + Arrays.toString(plusOne2(test4Nums)));
        System.out.println("5 - " + Arrays.toString(plusOne2(test5Nums)));



//        String numStr = String.valueOf(n + 1);

//        int[] nums = IntStream.range(0, numStr.length()).map(i -> Integer.parseInt(numStr.substring(i, i + 1))).toArray();

//        System.out.println(Arrays.toString(nums));
    }


    static int[] plusOne(int[] digits) {
        long n =  IntStream.range(0, digits.length)
                .mapToLong(i -> digits[i] * (long) Math.pow(10, digits.length - i - 1))
                .sum();

        System.out.println("BEFORE long: " + n);
        String nStr = String.valueOf(n + 1);
        System.out.println(nStr);

        return Stream.of(nStr.split("")).mapToInt(Integer::parseInt).toArray();
    }
//4, 3, 2, 1
    static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] resDigits = new int[digits.length + 1];
        resDigits[0] = 1;
        return resDigits;
    }
}
