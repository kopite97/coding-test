package com.sparta.club99.day14;

import java.util.Scanner;

public class Day14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = -1; // 거슬러 줄 수 없는 경우 초기값 -1

        if (n == 1 || n == 3) {
            result = -1;
        } else if (n % 5 == 0) {
            result = n / 5;
        } else {
            int count = n / 5;
            while (count >= 0) {
                int a = n - (count * 5); // 남은 금액
                if (a % 2 == 0) {
                    result = count + (a / 2); // 2원으로 얼마나 거슬러 줄 수 있는지
                    break;
                }
                count--; // 나누어 떨어지지 않는다면 5원 줄이고 다시
            }
        }

        System.out.println(result);
        sc.close();
    }

}
