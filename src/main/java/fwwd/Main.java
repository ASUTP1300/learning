package fwwd;

import first.Stub;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main extends Stub {


    public static void main(String[] args) {
        List<Integer> a = List.of(1, -2, 3, 4, 5);
        System.out.println(positiveSquare(a));

        Map<String, List<Integer>> map = Map.of(
                "c", List.of(8, 9),
                "a", List.of(6, 7)
        );
        List<Integer> integers = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .flatMap(e -> e.getValue().stream())
                .toList();

        System.out.println(integers);
    }

    public static String positiveSquare(List<Integer> nums) {
        // Пример входных данных: {3, 0, -5, 2, -2, 3}
        // Пример возвращаемого значения: "9,4,9"
        return nums.stream()
                .filter(n -> n >= 0)
                .map(n -> n * n)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    public static void doIt(String String) { //1
        int i = 10;
        i:
        for (int k = 0; k < 10; k++) { //2
            System.out.println(String + i); //3
            if (k * k > 10) continue i; //4
        }
    }

}

class Test {
    public static void test(Test t) {
        System.out.println("test" + t);
    }

}


class Box {
    private int weight = 0;

    public int getWeight() {
        return weight;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }
}

class Animal {
}

class Wolf extends Animal {
}

class Rabbit extends Animal {
}


