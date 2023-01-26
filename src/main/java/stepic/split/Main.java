package stepic.split;

import java.util.Spliterator;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        var spliterator1 = LongStream.range(0, 10_000).spliterator();
        System.out.println("Size spltr1 " + spliterator1.estimateSize());

        Spliterator.OfLong spliterator2 = spliterator1.trySplit();
        System.out.println("Size spltr1 " + spliterator1.estimateSize());
        System.out.println("Size spltr2 " + spliterator2.estimateSize());
        System.out.println("----------------------------------------------");

        Spliterator.OfLong spliterator3 = spliterator2.trySplit();
        System.out.println("Size spltr1 " + spliterator1.estimateSize());
        System.out.println("Size spltr2 " + spliterator2.estimateSize());
        System.out.println("Size spltr3 " + spliterator3.estimateSize());
        System.out.println("----------------------------------------------");

        Spliterator.OfLong spliterator4 = spliterator3.trySplit();
        System.out.println("Size spltr1 " + spliterator1.estimateSize());
        System.out.println("Size spltr2 " + spliterator2.estimateSize());
        System.out.println("Size spltr3 " + spliterator3.estimateSize());
        System.out.println("Size spltr4 " + spliterator4.estimateSize());
        System.out.println("----------------------------------------------");

        var spliterator = IntStream
                .generate(() -> 2)
                .limit(1)
                .peek(s -> System.out.println("Value " + s))
                .spliterator();



        spliterator.trySplit();
        System.out.println(" 1 " + spliterator.estimateSize());
//        spliterator.trySplit();
        System.out.println(" 2 " + spliterator.estimateSize() + " MAX_LONG " + Long.MAX_VALUE);
        IntConsumer displayMultiplied = v -> System.out.println(v * v);
        spliterator.tryAdvance(displayMultiplied);
    }
}
