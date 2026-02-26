package tree;

import java.io.*;
import java.util.*;

public class Virus {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        visited = new boolean[n + 1];
        dfs(1);

        int count =0;
        for(boolean b : visited){
            if(b) count++;
        }

        System.out.println(count-1);

    }

    static void dfs(int current){

        visited[current] = true;

        for(int next : graph[current]){

            if(!visited[next]){
                dfs(next);
            }
        }

    }
}
