package stepic.returnfunc;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        IntBinaryOperator bOperator = (a, b) -> Integer.sum(a, b);
//        BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
//                (integer, operator1) -> (arg1, arg2) -> IntStream.rangeClosed(arg1, arg2).reduce(integer, operator1);
//
//        IntBinaryOperator result =  reduceIntOperator.apply(5, bOperator);
//        System.out.println(result.applyAsInt(1, 4));

        System.out.println(Double.MAX_VALUE + Double.MAX_VALUE);

    }

}


