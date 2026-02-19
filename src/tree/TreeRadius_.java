package tree;

import java.io.*;
import java.util.*;
public class TreeRadius_ {
    public static int MaxDistance;
    public static int MaxNode;
    public static ArrayList<Node>[] Tree;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tree = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            Tree[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Tree[child].add(new Node(parent, weight));
            Tree[parent].add(new Node(child, weight));

        }


        if (n == 1) {
            System.out.println(0);
            return;
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        MaxDistance = 0;
        dfs(MaxNode, 0);

        System.out.println(MaxDistance);
    }

    public static void dfs(int current, int totalDistance) {
        if(visited[current]) {
            return;
        }
        visited[current] = true;

        if (MaxDistance < totalDistance) {
            MaxDistance = totalDistance;
            MaxNode = current;
        }

        for(Node next : Tree[current]) {
            if (!visited[next.v]) {
                dfs(next.v, totalDistance + next.w);
            }
        }
    }

    static class Node{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
