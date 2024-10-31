package com.sparta.club99.day4;

import java.util.Scanner;

public class bonus {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        long m = scanner.nextLong();
        scanner.close();
        int max = 0;
        for(int index : arr){
            if(max<=index){
                max = index;
            }
        }

        int left = 0;
        int right = max;
        int answer =0;

        while(left<=right){

            int mid = (left+right)/2;
            long sum = 0;

            for(int index : arr){
                if(index > mid){
                    sum += mid;
                }else{
                    sum += index;
                }
            }

            if(sum<=m){ // 불가능한 상한액
                answer = mid;
                left = mid +1;

            }else { // 가능한 상한액
                right = mid -1;
            }

        }

        System.out.println(answer);

    }

}
