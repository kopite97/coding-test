package binarySearch;

/**
 * https://www.acmicpc.net/problem/2110
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Router {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long left = 1;
        long right = arr[n - 1];
        long result = 0;

        while(left<=right){
            long mid = left + (right - left)/2; // 거리
            int count = 1;
            long s = arr[0];

            for(int v : arr){
                if(v-s >= mid){
                    count++;
                    s = v;
                }
            }

            if(count >= c){
                result = mid;
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }

        System.out.println(result);

    }
}
