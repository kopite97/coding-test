package binarySearch;

/**
 * https://www.acmicpc.net/problem/2343
 */

import java.io.*;
import java.util.StringTokenizer;

public class GuitarLesson {
    static int[] ARR;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ARR = new int[N];
        int sum = 0;
        int max = 0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st1.nextToken());
            if(num > max){
                max = num;
            }
            sum += num;
            ARR[i] = num;
        }

        long left = max;
        long right = sum;
        long result = 0;
        while(left<=right){

            long mid = left + (right - left)/2;

            if (check(mid)) {
                result = mid;
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        System.out.println(result);

    }

    public static boolean check(long k){

        int count = 1;
        int sum = 0;
        for (int v : ARR) {
            if (sum + v > k) {
                sum = 0;
                count ++;
            }
            sum += v;
        }

        return count <= M;
    }
}
