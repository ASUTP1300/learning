package yndx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class GoodTravel {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Writer writer = new FileWriter("output.txt");

        int n = Integer.parseInt(br.readLine());

        City[] cities = new City[n];
        int i = 0;
        while (i < n) {
            String[] strings = br.readLine().split(" ");
            cities[i] = new City(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            i++;
        }

        int k = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");

        int from = Integer.parseInt(data[0]) - 1;
        int to = Integer.parseInt(data[1]) - 1;

        for (int j = 0; j < n; j++){
            for (int p = j + 1; p < n; p++) {
                if (distance(cities[j], cities[p]) <= k) {
                    cities[j].adj.push(p);
                    cities[p].adj.push(j);
                }
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(from);
        cities[from].path = 0;

        int l = 0;

        while (!deque.isEmpty()) {

            //Берем первый элемент и удаляем!
            l = deque.poll();

            if (l == to) {
                break;
            }

            City city = cities[l];
            int path = city.path + 1;

            for (int h : city.adj) {
                int nextPath = cities[h].path;

                if (nextPath != -1) {
                    continue;
                }
                cities[h].path = path;

                if (h == to) {
                    deque = new ArrayDeque<>();
                    break;
                }
                deque.add(h);
            }
        }

        writer.write(cities[to].path + "");
        writer.flush();
       Arrays.asList(cities).forEach(x -> System.out.println(x.adj));
    }

    static long distance(City city1, City city2) {
        return Math.abs(city1.x - city2.x) + Math.abs(city1.y - city2.y);
    }



    static class City {
        int x;
        int y;
        int path = -1;
        LinkedList<Integer> adj = new LinkedList<>();

        public City(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "City{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
