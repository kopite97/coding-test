package graph;

import java.util.*;

public class LinkIsland {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int Distance;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int weight =  costs[i][2];

            graph[a].add(new Node(b, weight));
            graph[b].add(new Node(a, weight));
        }

        visited = new boolean[n];
        Distance = 0;
        dijkstra(0);

        return Distance;
    }

    void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.v;
            int currentWeight = current.w;

            Distance += currentWeight;
            visited[currentNode] = true;

            for( Node next : graph[currentNode]) {
                if (!visited[next.v]) {
                    pq.offer(new Node(next.v, next.w));
                }
            }
        }
    }

    class Node implements Comparable<Node> {
        int v;
        int w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }

    }
}
