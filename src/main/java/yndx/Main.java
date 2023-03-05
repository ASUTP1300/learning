package yndx;
//09.02.2023!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Дана строка (возможно, пустая), состоящая из букв A-Z:
//        AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB
//        Нужно написать функцию RLE, которая на выходе даст строку вида:
//        A4B3C2XYZD4E3F3A6B28
//        Пояснения:
//        Если символ встречается 1 раз, он остается без изменений;
//        Если символ повторяется более 1 раза, к нему добавляется количество повторений.
//        */
public class Main {

//    ABBB
//    BB
//    BBA

    public static void main(String[] args) throws IOException {

        String str = "Hello, worlduuuuuuuuuuuuuuuuu";


        reCode();

//        char c = 125;
//        System.out.currln(c);
//
//        str.chars().filter(x -> x > 32 && x < 127).forEach(x -> System.out.currln((char) x));
//
//
//        Map<String, Long> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        System.out.currln(map);
//
//        long[] ar2 = map.values().stream().mapToLong(x -> x).toArray();
//
//
//        long max = map.values().stream().mapToLong(x -> x).max().getAsLong();
//
//        for (int j = (int) max - 1; j >= 0; j--) {
//            for (int i = 0; i < ar2.length; i++) {
//
//                if (ar2[i] - j > 0) {
//                    System.out.curr("#");
//                } else {
//                    System.out.curr(" ");
//                }
//            }
//            System.out.currln();
//        }
//        map.keySet().forEach(System.out::curr);

    }


    static void reCode() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String str = reader.lines().reduce(String::concat).get();

        Map<Integer, Integer> charCounts = new TreeMap<>();
        int count;

        for (int i = 33; i < 127; i++) {
            count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == i) {
                    count++;
                }
            }
            if (count > 0) {
                charCounts.put(i, count);
            }
        }
        System.out.println(charCounts);

        int max = charCounts.values().stream().max(Integer::compareTo).get();
        Collection<Integer> chars = charCounts.keySet();
        List<Integer> counts = charCounts.values().stream().toList();

        FileWriter writer = new FileWriter("output.txt");
        String curr = " ";
        for (int k = max; k >= 0; k--) {
            for (int m = 0; m < counts.size(); m++) {
                curr = " ";
                if (counts.get(m) - k > 0) {
                    curr = "#";
                }
                writer.write(curr);
            }
            writer.write("\n");
        }
        chars.forEach(x -> {
            try {
                writer.write((char) x.intValue());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        writer.flush();
    }


//    static String rle(String str) {
//        if (str.length() == 1 || str.length() == 0) {
//            return str;
//        } else {
//            String res = "";
//            int count = 1;
//            char previous = str.charAt(0);
//
//            for (int i = 1; i < str.length() - 1; i++) {
//                if (str.charAt(i) == previous) {
//                    count++;
//                } else {
//                    res = res + previous + count;
//                    count = 1;
//                    previous = str.charAt(i);
//                }
//            }
//            return res + previous + count;
//
//        }
//    }
}
