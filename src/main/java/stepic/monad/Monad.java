package stepic.monad;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public interface Monad<T> {

    Monad<T> unit(T value);

    <U> Monad<U> map(Function<? super T, ? extends U> f);

    <U> Monad<U> flatMap(Function<? super T, Monad<U>> f);

    T get();
}

//**
//        * This generic class represents a monadic-like calculator
//        */
class Calculator<T extends Number> {
    /**
     * It represents a calculator in which an error has occurred
     */
    private static final Calculator<?> BROKEN_CALCULATOR = new Calculator<>(true);
    /**
     * The value stored inside the calculator
     */
    private final T value;
    /**
     * It determines if the calculator has an error
     */
    private final boolean hasError;

    private Calculator(T value) {
        this.value = value;
        this.hasError = false;
    }

    private Calculator(boolean hasError) {
        this.value = null;
        this.hasError = hasError;
    }

    /**
     * It returns a broken calculator with an explicit type casting.
     * We recommend you to use this method instead of accessing BROKEN_CALCULATOR directly.
     */
    @SuppressWarnings("unchecked")
    private static <T extends Number> Calculator<T> getBrokenCalculator() {
        return (Calculator<T>) BROKEN_CALCULATOR;
    }

    /**
     * The method creates a new instance of the calculator with a specified initial value.
     */
    public static <T extends Number> Calculator<T> of(T value) {
        // Implement this method
        return new Calculator<>(value);
    }

    /**
     * The method applies a given function to the value stored in the calculator.
     * It never throws ArithmeticException or NullPointerException
     */
    public <U extends Number> Calculator<U> eval(Function<? super T, ? extends U> mapper) {
        // write your code here
        U u = null;
        try {
            u = mapper.apply(value);
        } catch (Throwable t) {
            return getBrokenCalculator();
        }
        return new Calculator<>(u);
    }

    /**
     * The method passes the stored value to a given consumer only if no errors have occurred in the calculator.
     */
    public Calculator<T> consume(Consumer<T> consumer) {
        // write your code here
        if (this.hasError || value == null) {
            return getBrokenCalculator();
        } else {
            consumer.accept(value);
            return new Calculator<>(value);
        }
    }
}

class Main {
    public static void main(String[] args) {


        IntStream stream = IntStream.iterate(1, x -> x <= 10, x -> x + 1);
        System.out.println("min " + stream.min());
        System.out.println("max " + stream.max());

//        AtomicInteger
//
//        Calculator.of(12)
//                .consume(System.out::println)
//                .eval(v -> v / 0)
//                .consume(System.out::println);
//
//
//        Calculator.of(10) // init calculator with the default value 10
//                .eval(value -> value + 5)      // evaluates a new expression: 15
//                .consume(System.out::println)  // shows the current value 15
//                .eval(value -> null) // makes the value null
//                .consume(System.out::println); // doesn't print anything
    }
}