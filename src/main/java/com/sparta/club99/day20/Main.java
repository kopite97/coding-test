package com.sparta.club99.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        for (int i = 0; i < n && s > 0; i++) {

            //현재 위치에서 최대값 찾기 (s 범위 내에서)
            int maxIndex = i;
            for (int j = i + 1; j < n && j <= i + s; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex == i) {
                continue;
            }

            for (int j = maxIndex; j > i; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                s--;
            }

            if (s <= 0) {
                break;
            }
        }

        for (int index : arr) {
            System.out.print(index + " ");
        }

    }

}
