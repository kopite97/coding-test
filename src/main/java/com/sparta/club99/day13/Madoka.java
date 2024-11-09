package com.sparta.club99.day13;

import java.util.Scanner;

public class Madoka {
    public static void main(String[] args){

        System.out.println("프로그램 시작");
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        long cat = 0;
        int count =0;
        while(cat<n){
            if(cat*2 <= 1){
                cat++;
            }else{
                cat = cat*2;
            }
            count++;
        }

        System.out.println("count : "+count);
    }

}
