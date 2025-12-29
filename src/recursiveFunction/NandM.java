package recursiveFunction;

/**
 * https://www.acmicpc.net/problem/15649
 */

import java.io.*;
import java.util.StringTokenizer;

public class NandM {
    static boolean[] visited;
    static int[] arr;
    static int N;
    static int M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        arr = new int[M];

        dfs(0);
        System.out.println(sb);

    }

    static void dfs(int depth) {

        if (depth == M) {
            for (int var : arr) {
                sb.append(var).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;

                dfs(depth + 1);
                visited[i] = false;

            }

        }

    }

}
