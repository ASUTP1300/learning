package stream_api;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        double r =  (Math.random() * 2L);
        int a = (int) (Math.random() * 100);

        List<Worker> workers = new ArrayList<>();

//        IntStream.range(0, 1000).parallel().boxed()
//                .map(x -> new Worker("Name" + random(100), random(50), random(10_000), random(5000) + " " ))
//                .forEach(workers :: add);



        Worker worker1 = new Worker("Руслан", 31, 0, "developer");
        Worker worker2 = new Worker("Руслан", 31, 0, "developer");
        Worker worker3 = new Worker("Авик", 30, 0, "ОВК");

        Map<String, List<Worker>> mapWorkers = List.of(worker1, worker2, worker3).stream().collect(Collectors.groupingBy(Worker::getName));

        System.out.println(mapWorkers);

        Comparator<Worker> workerComparator = Comparator.comparing(Worker::getName);

        Set<Worker> workerSet = new TreeSet<>(workerComparator);
        workerSet.addAll(List.of(worker1, worker2, worker3));

        System.out.println("WorkerSet: " + workerSet);

    }


    static int  random(int n){
        return (int) (Math.random() * n);
    }



}
