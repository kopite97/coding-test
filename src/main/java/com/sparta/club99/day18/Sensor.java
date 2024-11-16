package com.sparta.club99.day18;

import java.util.Arrays;
import java.util.Scanner;

public class Sensor {

    public static void main(String[] args) {
        System.out.println("프로그램시작");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] positions = new int[n];
        for(int i=0;i<n;i++){
            positions[i] = sc.nextInt();
        }

        if(n <= k){
            System.out.println(0);
            return;
        }

        // 1 3 6 6 7 9
        // 2 3 0 1 2
        // [1,3] , [6,9]
        // 각 점의 차이를 배열을 내림차순
        // [3,2,2,1,0]
        // 6-2 =4
        // 2+2+1

        // 20 3 14 6 7 8 18 10 12 15
        // 3 6 7 8 10 12 14 15 18 20
        // 3 1 1 2 2  2   1  2  2
        // [3,2,2,2,2,2,1,1,1]
        // 10 - 5 = 5
        // 2+1+1+1
        // [3] , [6,8] [10,12] [14,15] [18,20]
        // 0 + 2+ 2+ 1+ 2
        Arrays.sort(positions);

        int index =0;
        int[] subArr = new int[n-1];
        while(index<n-1){
            int sub = positions[index+1] - positions[index];
            subArr[index] = sub;
            index++;
        }

        Arrays.sort(subArr);

        int result =0;
        for(int i=0;i<n-k;i++){
            result+=subArr[i];
        }

        System.out.println(result);

    }

}
