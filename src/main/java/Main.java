import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String str = "sdfdwsfwre!";
        str.charAt(0);
        Comparator<Character> characterComparator = Character::compareTo;
        Character cr = 'a';

        str.chars().sorted().forEach(System.out::println);

    }


    static void getError(){
        getError();
    }

    static void writeLn(String line){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\tmp\\nmcontract.txt", true))) {
            writer.newLine();
            writer.write(line);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
