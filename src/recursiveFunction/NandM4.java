package recursiveFunction;

/**
 * https://www.acmicpc.net/problem/15652
 */

import java.io.*;
import java.util.StringTokenizer;

public class NandM4 {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        sb = new StringBuilder();

        dfs(1,0);
        System.out.println(sb);

    }

    static void dfs(int start, int depth) {

        if (depth == M) {
            for (int var : arr) {
                sb.append(var).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] =i;
            dfs(i,depth+1);
        }

    }
}
