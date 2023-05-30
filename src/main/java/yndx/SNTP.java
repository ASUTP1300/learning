package yndx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SNTP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        LocalTime a = getTime(br.readLine());
        LocalTime b = getTime(br.readLine());
        LocalTime c = getTime(br.readLine());

        int dt = Math.round(1f * c.minusSeconds(a.toSecondOfDay()).toSecondOfDay() / 2);

        Writer writer = new FileWriter("output.txt");

        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");

        writer.write(b.plusSeconds(dt).format(df));
        writer.flush();
    }

    static LocalTime getTime(String time) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss");
        return LocalTime.parse(time);
    }
}
