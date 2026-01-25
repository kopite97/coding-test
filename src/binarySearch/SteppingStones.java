package binarySearch;

import java.util.Arrays;

public class SteppingStones {
    static int N;
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        System.out.println(solution(distance,rocks,n));

    }

    public static int solution(int distance, int[] rocks, int n) {
        N = n;
        Arrays.sort(rocks);

        long left = 1;
        long right = distance;
        long result = 0;

        int[] arr = new int[rocks.length + 2];
        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                arr[i] = 0;
            } else if (i == arr.length - 1) {
                arr[i] =distance;
            }else{
               arr[i] = rocks[i-1];
            }
        }

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (check(mid,arr)) {
                result = mid;
                left = mid +1;

            } else {
                right = mid -1;

            }
        }

        return (int)result;
    }

    public static boolean check(long mid,int[] arr) {

        int count = 0;
        int prev = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev < mid) {
                count++;
            }else{
                prev = arr[i];
            }


        }

        return count <= N;
    }
}
