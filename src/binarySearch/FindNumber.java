package binarySearch;

/**
 * https://www.acmicpc.net/problem/1920
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {

            int right = arr1.length-1;
            int left = 0;
            boolean isFind = false;

            while(left<=right){
                int mid = (left+right)/2;
                if (arr1[mid] == arr2[i]) {
                    isFind = true;
                    break;
                }

                if (arr1[mid] > arr2[i]) {
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            if (isFind){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
