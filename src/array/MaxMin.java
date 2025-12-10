package array;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/10818
 */
public class MaxMin {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String numArr = br.readLine();
        StringTokenizer st = new StringTokenizer(numArr);

        int max = -1000000;
        int min = 1000000;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num > max) max = num;
            if(num < min) min = num;
        }

        System.out.println(max);
        System.out.println(min);
    }
}
