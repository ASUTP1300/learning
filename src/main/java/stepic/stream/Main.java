package stepic.stream;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Stream.generate(random::nextDouble).limit(1).forEach(System.out::println);
        long l = 1;
        String str = "1kpoop";
        long[] ar = {1, 2, 4, 5};
//        LongStream.of(ar).boxed().collect(Collectors.toSet())


        str.chars().forEach(System.out::println);
       /// Stream.of(ar).forEach(System.out::println);
    }
}
