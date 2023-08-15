package yndx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GoodString {
    public static void main(String[] args) throws IOException {
        List<Man> men = List.of(new Man("Rus", 21), new Man("Rus",31), new Man("Tarlan", 38), new Man("Tarlan",50));


//       Map<String, Integer> map = men.stream().collect(Collectors.groupingBy(x -> x.name, Collectors.mapping(x2 -> x2.age, Collectors.summingInt(x3 -> -1 * x3))));
            men.forEach(x -> x.age *= -1);
         men.forEach(System.out::println);
//        System.out.println(map);
    }


   static class Man {

        String name;
        int age;

       public Man(String name, int age) {
           this.name = name;
           this.age = age;
       }

       @Override
       public String toString() {
           return "Man{" +
                   "age=" + age +
                   '}';
       }
   }

}
