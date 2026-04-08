package graph;

import java.util.*;

public class Delivery {
    static ArrayList<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int arr[][] = {{1, 2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};

        System.out.println(solution(n, arr, k));
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        graph = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i <road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int weight = road[i][2];

            graph[a].add(new Node(b, weight));
            graph[b].add(new Node(a, weight));
        }

        dist =  new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(1);

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.v;
            int currentWeight = current.w;

            if(dist[currentNode] < currentWeight) continue;

            for (Node next : graph[currentNode]) {
                int nextNode =  next.v;
                int nextWeight = currentWeight + next.w;
                if(nextWeight < dist[nextNode]){
                    dist[nextNode] = nextWeight;
                    pq.offer(new Node(nextNode, nextWeight));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
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
