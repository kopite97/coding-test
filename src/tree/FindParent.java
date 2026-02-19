package tree;

/**
 * https://www.acmicpc.net/problem/11725
 */

import java.io.*;
import java.util.*;


public class FindParent {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] parents = new int[n+1];
        boolean[] visited = new boolean[n+1];

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            for(int node : list[current]) {
                if(!visited[node]) {
                    visited[node] = true;
                    parents[node] = current;
                    q.add(node);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);

    }
}
