package fwwd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.IntStream;

public class GenInterfaces {

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("intefaces.txt"));
        writer.write(genInterface("A"));

        IntStream.rangeClosed(0, Integer.MAX_VALUE).boxed().map(n -> "A" + n).parallel().map(GenInterfaces::genInterface)
                .forEach(s -> {
                            try {
                                writer.write(s);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
        writer.flush();
    }

    static String genInterface(String name) {
        return "\ninterface " + name + " {}\n";
    }

}

