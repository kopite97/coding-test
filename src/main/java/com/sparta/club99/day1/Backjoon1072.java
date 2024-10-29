package com.sparta.club99.day1;

import java.util.Scanner;

public class Backjoon1072 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        long all = scanner.nextInt();
        long wins = scanner.nextInt();

        long rate = (wins*100)/all;


        if(rate >= 99){
            System.out.println(-1);
            return;
        }

        long count =0;

        while((wins+count)*100<(rate+1)*(all+count)){
            count++;
        }

        System.out.println(count);

        scanner.close();
    }

}
