package binarySearch;

/**
 * https://www.acmicpc.net/problem/10816
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dup = new int[20000001];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int index = num >0 ? num : num + 10000000;
            dup[index]++;
        }

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++){
            int target = Integer.parseInt(st2.nextToken());
            int index = target > 0 ? target : target + 10000000;
            sb.append(dup[index]).append(" ");
        }

        System.out.println(sb);
    }
}
