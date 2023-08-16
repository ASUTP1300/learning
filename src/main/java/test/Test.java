package test;

import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    private static final Pattern INT_FORMAT = Pattern.compile("\\d{1,20}");

    public static void main(String[] args) {

    }

    private static void validateValue(String value, int exponent) throws RuntimeException {
        if (value == null) {
            throw new RuntimeException("Null value");
        }
        final Pattern pattern = Pattern.compile(String.format("\\d{1,20}(\\.\\d{1,%d})", exponent));
        final Matcher matcher = pattern.matcher(value);
        System.out.println("matcher.matches() " + matcher.matches());
        if (!matcher.matches()) {
            final Matcher intMatcher = INT_FORMAT.matcher(value);
            if (!intMatcher.matches()) {
                throw new RuntimeException("Field [" + value + "] doesn't match pattern [" + pattern.pattern() + "]!");
            }
        }
    }
}
