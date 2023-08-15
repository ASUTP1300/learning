package master_java;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MultiplyArray {
    public static void main(String[] args) {
        int[][] a = new int[10][10];
        int[][] b = new int[1000][1000];

        Arrays.stream(a)
                .forEach(ai -> {
                    Arrays.stream(ai).forEach(aij -> {
                        aij += 1;
                    });
                });

        Stream.of(a, b).forEach(MultiplyArray::assignValues);
        Arrays.stream(a).map(Arrays::toString).forEach(System.out::println);
        trp(a);
        System.out.println("......");
        System.out.println("......");
        Arrays.stream(a).map(Arrays::toString).forEach(System.out::println);

        long start = System.currentTimeMillis();
        multiplyArr(a, b);
        System.out.printf("Duration is %d ", ((System.currentTimeMillis() - start)));
        Arrays.stream(multiplyArr(a, b)).map(Arrays::toString).forEach(System.out::println);


    }

    static void assignValues(int[][] a) {
        IntStream.range(0, a.length).forEach(i -> {
            IntStream.range(0, a[i].length).forEach(j -> a[i][j] = (int) (Math.random() * 10));
        });
    }

    static int[][] multiplyArr(int[][] a, int[][] b) {
        int rows = a.length;
        int colums = b[0].length;
        int[][] c = new int[rows][colums];

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                for (int k = 0; k < colums; k++) {
                    sum += a[i][k] * b[k][j];
                }
                c[i][j] = sum;
                sum = 0;
            }
        }
        return c;
    }

    static int[][] multiplyArrFast(int[][] a, int[][] b) {

        int rows = a.length;
        int colums = b[0].length;
        int[][] c = new int[rows][colums];

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                for (int k = 0; k < colums; k++) {
                    sum += a[i][k] * b[k][j];
                }
                c[i][j] = sum;
                sum = 0;
            }
        }
        return c;
    }

    //Транспонирование матрицы
    static void trp(int[][] a) {

        int rows = a.length;
        int columns = a[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                a[i][j] = a[j][i];
            }
        }
    }
}