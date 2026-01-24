package binarySearch;

/**
 * https://www.acmicpc.net/problem/2805
 */

import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class CutTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (max < num) {
                max = num;
            }
            arr[i] = num;
        }

        long left = 1;
        long right = max;
        long result = 0;

        while(left<=right){
            long mid = left + (right - left)/2;
            long sum = 0;
            for(int v : arr){
                long get = v - mid > 0 ? v - mid : 0;
                sum += get;
            }

            if(sum < m){
                right = mid - 1;
            }else{
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);

    }
}
