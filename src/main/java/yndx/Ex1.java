package yndx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Ex1 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

        String J = br.readLine();
        String S = br.readLine();

        Set<Character> charSet = new HashSet<>();

        for(char c : J.toCharArray()){
            charSet.add(c);
        }

        int count = 0;
        for(char c : S.toCharArray()){
            if(charSet.contains(c)){
                count++;
            }
        }

    }

}