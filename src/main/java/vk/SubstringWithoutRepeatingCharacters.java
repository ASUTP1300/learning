package vk;


import java.util.stream.IntStream;
import java.util.List;

public class SubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String test1 = "abcsdd";
        String test2 = "aaa";
        String test3 = "pwwwkew";
        String test4 = " ";
        String test5 = "";
        String test6 = "au";
        String test7 = "dvdf";
        String test8 = "anviaj";




        System.out.println("LENGTHOFLONGESTSUBSTRING1 Test 1: " + " " + test1 + " " + lengthOfLongestSubstring1(test1));
        System.out.println("LENGTHOFLONGESTSUBSTRING1 Test 2: " + " " + test2 + " " + lengthOfLongestSubstring1(test2));
        System.out.println("LENGTHOFLONGESTSUBSTRING1 Test 3: " + " " + test3 + " " + lengthOfLongestSubstring1(test3));
        System.out.println("LENGTHOFLONGESTSUBSTRING1 Test 4: " + " " + test4 + " " + lengthOfLongestSubstring1(test4));
        System.out.println("LENGTHOFLONGESTSUBSTRING1 Test 5: " + " " + test5 + " " + lengthOfLongestSubstring1(test5));
        System.out.println("LENGTHOFLONGESTSUBSTRING1 Test 6: " + " " + test6 + " " + lengthOfLongestSubstring1(test6));
        System.out.println("LENGTHOFLONGESTSUBSTRING1 Test 7: " + " " + test7 + " " + lengthOfLongestSubstring1(test7));
        System.out.println("LENGTHOFLONGESTSUBSTRING1 Test 8: " + " " + test8 + " " + lengthOfLongestSubstring1(test8));
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------");


        System.out.println("LENGTHOFLONGESTSUBSTRING2 Test 1: " + " " + test1 + " " + lengthOfLongestSubstring2(test1));
        System.out.println("LENGTHOFLONGESTSUBSTRING2 Test 2: " + " " + test2 + " " + lengthOfLongestSubstring2(test2));
        System.out.println("LENGTHOFLONGESTSUBSTRING2 Test 3: " + " " + test3 + " " + lengthOfLongestSubstring2(test3));
        System.out.println("LENGTHOFLONGESTSUBSTRING2 Test 4: " + " " + test4 + " " + lengthOfLongestSubstring2(test4));
        System.out.println("LENGTHOFLONGESTSUBSTRING2 Test 5: " + " " + test5 + " " + lengthOfLongestSubstring2(test5));
        System.out.println("LENGTHOFLONGESTSUBSTRING2 Test 6: " + " " + test6 + " " + lengthOfLongestSubstring2(test6));
        System.out.println("LENGTHOFLONGESTSUBSTRING2 Test 7: " + " " + test7 + " " + lengthOfLongestSubstring2(test7));
        System.out.println("LENGTHOFLONGESTSUBSTRING2 Test 8: " + " " + test8 + " " + lengthOfLongestSubstring2(test8));

        List.of(test1,
                test2,
                test3,
                test4,
                test5,
                test6,
                test7,
                test8).stream()
                    .forEach(str -> {
                        String out = "TEST1 : lengthOfLongestSubstring 1: " + lengthOfLongestSubstring1(str) + " ____ " + "lengthOfLongestSubstring 2: " + lengthOfLongestSubstring2(str);
                        System.out.println(out);
                    });

    }

    static int lengthOfLongestSubstring1(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String accum = "";
        int max = 1;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (accum.indexOf(chars[i]) == -1) {
                accum += chars[i];
            } else {
                max = Math.max(accum.length(), max);

                if (chars[i] == chars[i - 1]) {
                    accum = "" + chars[i];
                } else {
                    accum = "" + chars[i - 1];
                    i--;
                }

            }
            if (i == chars.length - 1) {
                max = accum.length() > max ? accum.length() : max;
            }
        }

        return max;
    }

    static int lengthOfLongestSubstring2(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String accum = "";
        int max = 1;

        int i = 0;
        int j;

        char[] chars = s.toCharArray();
        while (i < chars.length - 1) {
            j = i;
            accum = "";

            while (j < chars.length) {
                if (accum.indexOf(chars[j]) == -1) {
                    accum += chars[j];
                } else {
                    j = chars.length;
                }
                j++;
            }
            max = accum.length() > max ? accum.length() : max;
            i++;
        }

        return max;
    }


}
