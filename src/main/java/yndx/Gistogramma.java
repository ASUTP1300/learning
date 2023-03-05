package yndx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class Gistogramma {

    public static void main(String[] args) throws java.io.IOException {
        reCode();
    }

    static void reCode() throws java.io.IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String str = reader.lines().reduce(String::concat).get();

        java.util.Map<Integer, Integer> charCounts = new java.util.TreeMap<>();
        int count;

        for (int i = 33; i < 127; i++) {
            count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == i) {
                    count++;
                }
            }
            if (count > 0) {
                charCounts.put(i, count);
            }
        }

        int max = charCounts.values().stream().max(Integer::compareTo).get();
        java.util.Collection<Integer> chars = charCounts.keySet();
        java.util.List<Integer> counts = charCounts.values().stream().collect(java.util.stream.Collectors.toList());

        FileWriter writer = new FileWriter("output.txt");
        String curr = " ";
        for (int k = max - 1; k >= 0; k--) {
            for (int m = 0; m < counts.size(); m++) {
                curr = " ";
                if (counts.get(m) - k > 0) {
                    curr = "#";
                }
                writer.write(curr);
            }
            writer.write("\n");
        }
        chars.forEach(x -> {
            try {
                writer.write((char) x.intValue());
            } catch (java.io.IOException e) {
                throw new RuntimeException(e);
            }
        });
        writer.flush();
    }
}
