package sort;

/**
 * https://www.acmicpc.net/problem/11399
 */

import java.io.*;
import java.util.*;

public class ATM {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] sumArr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+= arr[i];
            sumArr[i] = sum;
        }

        int result = 0;
        for(int v : sumArr){
            result+=v;
        }

        System.out.println(result);
    }
}
