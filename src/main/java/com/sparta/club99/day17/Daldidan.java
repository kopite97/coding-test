package com.sparta.club99.day17;

import java.util.Scanner;

public class Daldidan {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long count = 10;
        long len = 1;
        while(n >=len*2){
            count++;
            len*=2;
        }

        System.out.println(count);

    }

}
