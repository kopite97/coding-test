package recursiveFunction;

/**
 * https://www.acmicpc.net/problem/4779
 */

import java.io.*;

public class CantorSet {

    static char[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int size = (int)Math.pow(3, n);
            arr = new char[size];

            for (int i = 0; i < size; i++) {
                arr[i] = '-';
            }

            dfs(0,size);
            for (char var : arr) {
                sb.append(var);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int start,int size) {
        if (size == 1) {
            return;
        }
        int newSize = size/3;

        for (int i = start + newSize; i < start + 2 * newSize; i++) {
            arr[i] = ' ';
        }

        // 왼쪽 구간 호출
        dfs(start, newSize);
        dfs(start + 2 + newSize, newSize);


    }
}
