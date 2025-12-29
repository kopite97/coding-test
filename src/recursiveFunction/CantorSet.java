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

            dfs(size/3,size);
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
        int s = size/3;

        for (int i = start; i < start+s; i++) {
            arr[i] = ' ';
        }

        // 왼쪽으로 보내기
        dfs(start - (s / 3) * 2, s);
        dfs(start + s + s / 3, s);


    }
}
