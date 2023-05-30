import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "sdfdwsfwre!";
        str.charAt(0);
        Comparator<Character> characterComparator = Character::compareTo;
        Character cr = 'a';



        Pattern pattern = Pattern.compile("[0-9]{25}");

        String validStr = "40706810600000105977";
        System.out.println("Длина строки " + validStr.length());

        System.out.println(pattern.matcher(validStr).matches());
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
