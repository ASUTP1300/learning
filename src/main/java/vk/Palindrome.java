package vk;

import java.util.stream.IntStream;

public class Palindrome {

    public static void main(String[] args) {
        isPalindrome("Marge, let's \"[went].\" I await {news} telegram.");
        IntStream.range(32, 127).forEach(x -> System.out.println((char) x + " - " + x));

    }

    static boolean isPalindrome(String str) {
        String accumulate = "";
        String finish = str.toLowerCase().chars().filter(x -> x > 96 && x < 127).boxed().map(Character::toString).reduce(accumulate, String::concat);

        if (finish.isBlank()) {
            return true;
        } else if (finish.length() == 1) {
            return false;
        }
        Boolean b = true;
        System.out.println("finish " + finish);

        IntStream.range(0, finish.length() / 2).boxed().peek(x -> System.out.println("inish.charAt(x) == finish.charAt(finish.length() - 1 - x)\n" +
                +finish.charAt(x) + " " + finish.charAt(finish.length() - 1 - x))).map(x -> finish.charAt(x) == finish.charAt(finish.length() - 1 - x)).peek(System.out::println).reduce(b, (x1, x2) -> x1 & x2);
        System.out.println(finish);
        return false;
    }
}
