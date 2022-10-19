package yndx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3 {
    public static void main(String[] args) throws IOException {

//    paren(6);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        String curr = "";
//        String prev = "";
//        for(int i = 0; i < n; i++){
//            if(!(curr = br.readLine()).equals(prev)){
//                System.out.println(curr);
//                prev = curr;
//            }
//        }

        System.out.println(median(1, 2, 3));
        System.out.println(median(2, 1, 3));
        System.out.println(median(1, 3, 2));
    }



    static void paren(int n){
       gen("", 0, 0, n);
    }

    static void gen(String curr, int open, int close, int n){
        if(curr.length() == n){
            System.out.println(curr);
        }
        if(open < n >> 1){
            gen(curr + "(", open + 1, close, n);
        }
        if(close < open){
            gen(curr + ")", open , close + 1, n);
        }
    }

    static int median(int a1, int a2, int a3){
        if(a1 > a2){
            if(a2 > a3){
                return a2;
            } else {
                if(a3 < a1){
                    return a3;
                } else {
                    return a1;
                }
            }
        } else {
            if(a1 > a3){
                return a1;
            } else {
                if(a3 < a2){
                    return a3;
                } else {
                    return a2;
                }
            }
        }
    }
}