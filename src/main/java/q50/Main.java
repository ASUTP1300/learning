package q50;

public class Main {
    public static void main(String[] args) {
        String str1 = "A";
        String str2 = "B";

        System.out.println(String.join("|", str1, str2));
       // fibonacci(5);
    }

    static void fibonacci(int num){
        int n = 0;
        int n0 = 0;
        int n1 = 1;

        while (n < num){
            System.out.println(n);
            n0 = n1;
            n1 = n;
            n = n0 + n1;
        }
    }
}
