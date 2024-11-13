package com.sparta.club99.day16;

import java.util.Scanner;

public class Day16 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int count =0;
        for(int i =n-2;i>=0;i--){
            if(arr[i] >=arr[i+1]){
                int sub = arr[i+1] - arr[i] -1;
                arr[i] = arr[i] + sub;
                count += (-sub);
            }
        }

        System.out.println(count);
    }

}
