package integrity.collection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

public class Main {
    public static void main(String[] args) {
        try{
            bar();
        }catch(NullPointerException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
            Exception exception2 = new Exception();
        }

        foo();
    }

    public static void bar(){

    }

    public static void foo() throws NullPointerException{

    }
}



