package order;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;


public class SortList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(3);
        list.add(3);
        list.add(4);
        list.add(1);


        System.out.println(2.0 /100.0);


    }

    static List<Integer> spSort(List<Integer> list) {
        return list.stream().filter(n -> n % 2 != 0).sorted().peek(System.out::println)
                .flatMap(a -> list.stream().map(b -> b % 2 != 0 ? a : b)).distinct().toList();
    }
}

