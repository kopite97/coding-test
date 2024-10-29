package com.sparta.club99.day2;

import java.util.Scanner;

public class Baek11561 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        long[] arr = new long[testCase];

        for(int i=0;i<testCase;i++){
            arr[i] = findMax(scanner.nextLong());
        }

        for(int i=0;i<testCase;i++){
            System.out.println(arr[i]);
        }
        scanner.close();
    }

    public static long findMax(long n){
        long left = 1,right = n;
        long result = 0;

        while(left<=right){
            long mid = (left+right)/2;

            if( mid > (2*n)/(mid+1)){
                right = mid -1;
                continue;
            }

            long sum = mid * (mid+1) / 2;

            if(sum <= n){
                result = mid;
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return result;
    }
}
