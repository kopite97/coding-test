package com.sparta.club99.day19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 강의 정보를 저장할 배열
        int[][] lectures = new int[n][2];

        for (int i = 0; i < n; i++) {
            sc.nextInt(); // 강의 번호는 무시
            lectures[i][0] = sc.nextInt();
            lectures[i][1] = sc.nextInt();
        }

        // 시작 시간 기준으로 정렬
        Arrays.sort(lectures, Comparator.comparingInt(a -> a[0]));

        // 우선순위 큐를 사용하여 종료 시간을 관리
        PriorityQueue<Integer> endTimeHeap = new PriorityQueue<>();

        for (int[] lecture : lectures) {
            // 현재 강의의 시작 시간보다 먼저 끝나는 강의 제거
            if (!endTimeHeap.isEmpty() && endTimeHeap.peek() <= lecture[0]) {
                endTimeHeap.poll();
            }

            // 현재 강의의 종료 시간을 추가
            endTimeHeap.add(lecture[1]);
        }

        // 남아 있는 강의실 수가 필요한 최소 강의실 개수
        System.out.println(endTimeHeap.size());
    }
}
