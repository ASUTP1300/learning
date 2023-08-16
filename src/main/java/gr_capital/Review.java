package gr_capital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Review {
    public static void main(String[] args) {

        List<String> strings = List.of("AB", "BA", "EC");

        strings.stream()
                .sorted(Comparator.comparing(s -> s.substring(1)))
                .forEach(s -> System.out.println("String " + s));

        Int int1 = Int.valueOf(125);
        Int int2 = Int.valueOf(-1);
        Int int3 = Int.valueOf(257);
    }

    static void aboutStrings() {
        String str1 = "String1";
        String str2 = "String" + 1;
        String str3 = "String1";

        System.out.println(str1 == str2);
        System.out.println(str1 == (getString() + 1));
        System.out.println(str1 == str3);
    }

    static String getString() {
        return "String";
    }


}

class Int {
    private int value;

    public Int(int value) {
        this.value = value;
    }

    private static Int[] cache = new Int[256];

    static {
        IntStream.rangeClosed(-128, 127).forEach(n -> {
            cache[n + 128] = new Int(n);
            System.out.println("Cash has received Int value " + n);
        });
        System.out.println(Arrays.toString(cache));
    }

    static Int getFromCache(int value) {
        Int target = cache[value + 128];
        System.out.printf("Int %s was gotten \n", target);
        return target;
    }

    public static Int valueOf(int value) {
        if (value >= -128 && value <= 127) {
            return getFromCache(value);
        } else {
            return new Int(value);
        }
    }

    @Override
    public String toString() {
        return "Int{" +
                "value=" + value +
                '}';
    }

}


