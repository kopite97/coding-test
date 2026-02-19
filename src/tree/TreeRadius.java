package tree;

/**
 * https://www.acmicpc.net/problem/1967
 */

import java.io.*;
import java.util.*;

public class TreeRadius {
    static ArrayList<Node>[] Tree;
    static boolean[] Visited;
    static int MaxDistance = 0;
    static int MaxNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            Tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Tree[parent].add(new Node(child, weight));
            Tree[child].add(new Node(parent, weight));
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        Visited = new boolean[n + 1];
        dfs(1, 0);

        Visited = new boolean[n + 1];
        MaxDistance = 0;
        dfs(MaxNode, 0);
        System.out.println(MaxDistance);
    }

    public static void dfs(int current, int totalDistance) {
        if(Visited[current]) return;
        Visited[current] = true;

        if (MaxDistance < totalDistance) {
            MaxDistance = totalDistance;
            MaxNode = current;
        }

        for(Node next : Tree[current]) {
            if (!Visited[next.v]) {
                dfs(next.v, totalDistance+next.w);
            }
        }
    }

    static class Node{
        int v; // 연결된 노드 번호
        int w; // 가중치

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
