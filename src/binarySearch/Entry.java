package binarySearch;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43238
 */

import java.util.*;

public class Entry {
    public static void main(String[] args){

        int n =6;
        int[] times = {7, 10};
        System.out.println(solution(n,times));
    }

    public static long solution(int n, int[] times) {

        int max = 0;
        for(int v : times){
            if(v>max)
                max = v;
        }

        long left = 1;
        long right = (long)max *n;
        long result = 0;

        while(left<=right){
            long mid = left + (right - left)/2;

            long sum = 0;
            for(int v : times){
                sum+= mid/v;
            }

            if (sum >= n) {
                result = mid;
                right = mid -1;
            }else{
                left = mid +1;

            }
        }

        return result;
    }
}
