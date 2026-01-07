package recursiveFunction;

/**
 * https://www.acmicpc.net/problem/11729
 */

import java.io.*;

public class Hanoi {
    static StringBuilder sb;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        count =0;

        hanoi(n, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }

    public static void hanoi(int n,int start,int mid,int end){
        count++;
        if(n == 1){
            sb.append(start + " " + end + "\n");
            return;
        }

        // n-1개의 원판을 보조 기둥으로 이동
        hanoi(n - 1, start, end, mid);

        // 원판 직접 옮기기
        sb.append(start + " " + end + "\n");

        // 보조 기둥에 있던 n-1개의 원판을 목적지로 이동 (출발지 기둥을 보조로 사용)
        hanoi(n - 1, mid, start, end);

    }
}
