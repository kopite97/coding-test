package com.sparta.club99.Baekjoon1072;

import java.util.Scanner;

public class Math1072 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long all = scanner.nextLong();    // 전체 게임 횟수
        long wins = scanner.nextLong();   // 승리한 횟수
        scanner.close();

        long rate = (wins * 100) / all;  // 현재 승률 계산

        if (rate >= 99) {  // 승률이 99 이상이면 승률을 올릴 수 없으므로 -1 반환
            System.out.println(-1);
            return;
        }

        // N을 계산하여 승률을 rate + 1로 올리기 위한 최소 추가 승리 횟수를 찾음
        long answer = ((rate + 1) * all - 100 * wins) / (100 - (rate + 1));

        // 올림 처리하여 필요한 정수 승리 횟수로 반영
        if (((rate + 1) * all - 100 * wins) % (100 - (rate + 1)) != 0) {
            answer++;
        }

        System.out.println(answer);
    }

}
