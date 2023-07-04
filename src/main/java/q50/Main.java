package q50;

public class Main {
    public static void main(String[] args) {
        long l = 100512;

        System.out.println((double) l / 100);


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
