package tree;

/**
 * https://www.acmicpc.net/problem/1260
 */

import java.io.*;
import java.util.*;

public class DFSandBFS {
    static ArrayList<Integer>[] Tree;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        Tree = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            Tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer strt = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(strt.nextToken());
            int b = Integer.parseInt(strt.nextToken());

            Tree[a].add(b);
            Tree[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(Tree[i]);
        }

        visited = new boolean[n+1];
        sb = new StringBuilder();
        dfs(v);
        System.out.println(sb);

        visited = new boolean[n+1];
        sb = new StringBuilder();
        bfs(v);
        System.out.println(sb
        );
    }

    static void dfs(int current) {
        visited[current] = true;
        sb.append(current + " ");

        for(int next : Tree[current]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int current) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(current);
        visited[current] = true;

        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            sb.append(currentNode + " ");
            for(int next : Tree[currentNode]) {
                if(!visited[next]){
                    visited[next]  = true;
                    queue.add(next);
                }
            }
        }

    }
}
