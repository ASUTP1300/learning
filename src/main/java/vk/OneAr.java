package vk;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


public class OneAr {
    // Дан массив из нулей и единиц. Нужно определить, какой максимальный по длине подынтервал единиц можно получить,
// удалив ровно один элемент массива. Вернуть 0, если такого подынтервала не существует.
// Удалять один элемент из массива обязательно.
// [1, 1, 0, 1, 0] = 3
// [1, 1, 1] = 2
// [1, 1, 1, 0, 1, 0, 1, 1, 1]
// [1, 1, 1, 0, 0, 1, 1, 1, 1]
// [1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1]
// [1, 1, 1, 0, 1, 0, 0, 0 ,1 , 1, 1, 1]
    public static void main(String[] args) {
        int[] testAr1 = new int[]{1, 1, 0, 1, 0};
        int[] testAr2 = new int[]{1, 1, 1};
        int[] testAr3 = new int[]{1, 1, 1, 0, 1, 0, 1, 1, 1};
        int[] testAr4 = new int[]{1, 1, 1, 0, 0, 1, 1, 1, 1};
        int[] testAr5 = new int[]{1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1};
        int[] testAr6 = new int[]{1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1};

        int[][] testArrays = new int[][]{testAr1, testAr2, testAr3, testAr4, testAr5, testAr6};
        List<Integer> result = List.of(3, 2, 4, 4, 4, 5);

        IntStream.range(0, testArrays.length)
                .forEach(i -> System.out.println("Test num " + i + " " + Arrays.toString(testArrays[i]) + " : "
                        + " First: " + determineInterval(testArrays[i]) + " | Second: " + determineInterval2(testArrays[i]) + " "
                        + " Right: " + result.get(i)));


//        1, 1, 1, 0, 1 /0
//           1, 1, 0, 1 ?
//              1, 0, 1 ?
//                 0, 1 ?
//                    1, 0, 1, 1, 1, 1
//                       0, 1, 1, 1, 1
//                          1, 1, 1, 1

//   [1, 0, 1, 1, 0, 1, 1, 1,1, 1, 1, 1, 1]

        System.out.println("1 " + determineInterval(testAr1));
        System.out.println("2 + 2 + 2 -" + determineInterval(testAr2));
        System.out.println("1 " + determineInterval(testAr3));
        System.out.println("1 " + determineInterval(testAr6));

        System.out.println("2 " + determineInterval2(testAr1));
        System.out.println("2 + 2 + 2 -" + determineInterval2(testAr2));
        System.out.println("2 " + determineInterval2(testAr3));
        System.out.println("2 " + determineInterval2(testAr6));

    }

    static int determineInterval(int[] ar) {
        int i = 0;
        int ch = 1;
        int count = 0;
        int max = 0;


        while (i < ar.length) {
            if (ar[i] == 1) {
                count++;
                i++;
            } else {
                if (ch > 0) {
                    ch--;
                    i++;
                } else {
                    max = Math.max(count, max);
                    count = 0;
                    ch = 1;
                }
            }
        }
        max = Math.max(count, max);
        return max;
    }

    static int determineInterval2(int[] ar) {
        int l = 0;
        int r = 0;
        int ch = 1;

        int count = 0;

        int max = 0;

        while (l < ar.length) {
            r = l;
            while (r < ar.length && ch >= 0 ) {
                if (ar[r] == 1) {
                    count++;
                } else {
                    ch--;
                }
                r++;
            }
            count = ch <= 0 ? count : count - 1;
            max = Math.max(count, max);
            count = 0;
            ch = 1;

            l++;
        }
        return max;
    }
}
