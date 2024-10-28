package com.sparta.club99.Baekjoon1072;

import java.util.Scanner;

public class Binary {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        long all = scanner.nextInt();
        long wins = scanner.nextInt();
        scanner.close();

        long rate = (wins*100)/all;

        if (rate >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 0;
        long right = all;
        long answer = -1;

        while(left <= right){
            long mid = (left + right) /2; // 중간 값을 추가 승리 횟수로 가정
            long newRate = ((wins+mid)*100)/(all+mid);
            if(newRate > rate) {
                answer = mid;
                right = mid - 1; // 더 적은 승리 횟수로 목표를 달성할 수 있는 지 확인
            }else{
                left = mid +1; // 더 많은 승리 필요
            }
        }

        System.out.println(answer);
    }
}
