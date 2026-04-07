package graph;

import java.io.*;
import java.util.*;

public class MinRoot {
    static ArrayList<Node>[] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int root = Integer.parseInt(br.readLine());

        graph = new  ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u =  Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(m, w));
        }
        dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(root);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dijkstra(int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0)); // 시작지점
        dist[x] = 0;

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.to;
            int currentWeight = current.weight;
            if(dist[currentNode] < currentWeight) continue;

            for (Node next : graph[currentNode]) {
                int nextWeight = next.weight + currentWeight;
                if (nextWeight < dist[next.to]) {
                    dist[next.to] = nextWeight;
                    pq.offer(new Node(next.to, nextWeight));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}

