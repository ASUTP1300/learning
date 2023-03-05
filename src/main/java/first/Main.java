package first;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {11, 12, 0, 11};
        System.out.println(groupByCount(arr));

        Integer integer = 1;

    }

    static int maxSameSubstr(String str) {
        if (str.length() == 1) {
            return -1;
        }

        int max = 0;
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                if (max < count) {
                    max = count;
                    count = 1;
                }
            }
        }
        if (max < count) {
            max = count;
        }

        return max;
    }


    static String stringCompress(String str) {
        char last = str.charAt(0);
        int count = 0;

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                stringBuffer.append(last);
                stringBuffer.append(count);
                count = 1;
                last = str.charAt(i);
            }
        }
        stringBuffer.append(last);
        stringBuffer.append(count);
        return stringBuffer.toString();
    }



    int bSearch(int[] a, int target){
        int l = 0;
        int r = a.length - 1;

        while(l < r){
            int m = (r + l)/2;
            if(target == a[m]){
                return m;
            }
            if(target < a[m]){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }


    static Map<Integer, Integer> groupByCount(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int val = 0;
        for(int a : arr){
            if(map.containsKey(a)){
                val = map.get(a) + 1;
                map.put(a, val);
            } else {
                map.put(a, 1);
            }
        }
        return map;
    }

}
