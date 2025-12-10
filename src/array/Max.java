package array;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/2562
 */

public class Max {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int maxIndex =0;
        for(int i=0;i<9;i++){
            int num = Integer.parseInt(br.readLine().trim());
            if( num > max){
                max = num;
                maxIndex = i;
            }
        }

        System.out.println(max);
        System.out.println(maxIndex+1);
    }
}
