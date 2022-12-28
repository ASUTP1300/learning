package stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        double r =  (Math.random() * 2L);
        int a = (int) (Math.random() * 100);

        List<Worker> workers = new ArrayList<>();

        IntStream.range(0, 1000).parallel().boxed()
                .map(x -> new Worker("Name" + random(100), random(50), random(10_000), random(5000) + " " ))
                .forEach(workers :: add);



        Map<String, List<Worker>> map = workers.stream().collect(Collectors.groupingBy(Worker::getName));

        Map<String, Long> map2 = workers.stream().collect(Collectors.groupingBy(Worker::getName, Collectors.counting()));

        Set<String> stringSet = workers.stream().map(Worker::getName).collect(Collectors.toSet());





    }


    static int  random(int n){
        return (int) (Math.random() * n);
    }



}
