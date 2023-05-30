package vk;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CompressString {
    public static void main(String[] args) {
        char[] chars = new char[]{'a','a','b','b','c','c','c'};

        prepareCompress(chars);
        String str = "abcabcbb";
        System.out.println(str.contains(str.subSequence(0, 0)));
        System.out.println(str.chars().distinct().count());
        System.out.println(add('A', 2));

    }

    //abcc

    static void prepareCompress(char[] chars) {
        StringBuilder accum = new StringBuilder(); //accum

        int i = 0; //Первый указатель
        int j = 1; //Второй указатель

        int count = 1; //Счетчик

        while (j < chars.length) {
            if (chars[i] == chars[j]) {
                count++;
            } else {
                accum.append(add(chars[i], count));
                count = 1;
                i = j;
            }
            j++;
        }
        accum.append(add(chars[i], count));
        System.out.println(accum);

        for (int k = 0; k < accum.length(); k++) {
            chars[k] = accum.charAt(k);
        }
        System.out.println(Arrays.toString(chars));
    }


    static String add(char c, int count) {
        return count > 1 ? c + "" + count : c + "";
    }
}
