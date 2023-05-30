package vk;

import java.util.stream.IntStream;

public class MountainArray {

    public static void main(String[] args) {
        int[] testArr1 = new int[]{1, 5, 4, 3, 5, 4, 2, 1};
        int[] testArr2 = new int[]{3, 5, 5};
        int[] testArr3 = new int[]{0, 3, 2, 1};
        int[] testArr4 = new int[]{4, 1};
        int[] testArr5 = new int[]{0, 1, 2, 1, 2};


        System.out.println("TEST 1 : [1, 5, 4, 3, 5, 4, 2, 1]: " + validMountainArray(testArr1));
        System.out.println("TEST 2 : [3, 5, 5]: " + validMountainArray(testArr2));
        System.out.println("TEST 3 : [0, 3, 2, 1]: " + validMountainArray(testArr3));
        System.out.println("TEST 4 : [4, 1]: " + validMountainArray(testArr4));
        System.out.println("TEST 5 : [0,1,2,1,2]: " + validMountainArray(testArr5));



    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr[0] > arr[1] || arr[arr.length - 1] > arr[arr.length - 2]) {
            return false;
        }

        int i = 0;

        while (i < arr.length - 1 && arr[i + 1] > arr[i]) { // 1 > 0, 2 > 1, 1 > 2 false
            i++; //1
        }
        if (arr[i + 1] == arr[i]) {
            return false;
        }
        while (i < arr.length - 1 && arr[i + 1] < arr[i]) { //1 < 2
            i++;//3
        }

        if (i == arr.length) {
            return true;
        }

        return false;
    }
}
