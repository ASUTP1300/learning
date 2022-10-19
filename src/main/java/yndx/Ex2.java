package yndx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());

        int current = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(Integer.parseInt(br.readLine()) > 0 ){
                current++;
                max = Math.max(max, current);
            } else {
                current = 0;
            }
        }
        System.out.println(max);
    }
}
