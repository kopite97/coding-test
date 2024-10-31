package com.sparta.club99.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekDFS {

    static ArrayList<Integer>[] graph;
    static int[] order;
    static boolean[] visited;
    static int counter = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        order = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>(); // 각 정점의 리스트 초기화
        }

        //간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int v){
        visited[v] = true;
        order[v] = counter++;

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

}
