package binarySearch;

/**
 * https://www.acmicpc.net/problem/1654
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CutLAN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long result = 0;

        long left = 1;
        long right = arr[arr.length - 1];

        while(left<=right){
            long mid = left + (right - left)/2;
            long count = 0;

            for(int v : arr){
                count+=(v/mid);
            }

            if(count < n){
                right = mid -1;
            }else{
                result = mid;
                left = mid+1;
            }

        }
        System.out.println(result);

    }
}
