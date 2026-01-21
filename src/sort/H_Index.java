package sort;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */

public class H_Index {
    public static void main(String[] args) {

        int[] arr = {3, 0, 6, 1, 5};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        Arrays.sort(arr);


        for(int i=0;i<arr.length-1;i++){
            if (arr[i] >= arr.length - i) {
                return arr.length -i;
            }
        }

        return 0;
    }
}
