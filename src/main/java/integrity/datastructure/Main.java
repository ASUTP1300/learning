package integrity.datastructure;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();
        List<String> stringList = List.of("A", "B", "C");

        stringList.forEach(strings :: push);
        System.out.println(strings.peek());
//        Queue<String> queue = new ArrayDeque<>();
//        stringList.forEach(queue :: add);
//        System.out.println(queue.poll());

        Iterator<String> iterator = stringList.iterator();

        while (iterator.hasNext()){
            System.out.println("Working Iterator " + iterator.next());
        }


    }

    static void quickSort(int[] a){
        int pivot = a.length - 1;
        int j = 0;
        int temp = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] < pivot){
                i++;
            }
        }
    }
}
