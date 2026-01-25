package binarySearch;

/**
 * https://www.acmicpc.net/problem/2512
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Budget {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long left = 0;
        long right = arr[n - 1];
        long result = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2; // 예산

            long sum =0;
            for (int v : arr) {
                if(v<=mid){
                    sum += v;
                }else{
                    sum+=mid;
                }
            }

            if (sum <=m) {
                result = mid;
                left = mid +1;

            }else{
                right = mid -1;
            }
        }

        System.out.println(result);

    }
}
