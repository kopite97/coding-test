package com.sparta.club99.day10;

import java.util.*;
import java.io.*;

public class bfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int k = Integer.parseInt(st.nextToken()); // 찾고자 하는 최단 거리
        int x = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        // 그래프를 인접 리스트로 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }

        // BFS를 위한 거리 배열 초기화
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[x] = 0;

        // BFS 구현
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                // 아직 방문하지 않은 도시라면
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        // 결과 출력
        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                found = true;
            }
        }

        // 거리가 k인 도시가 없는 경우 -1 출력
        if (!found) {
            System.out.println(-1);
        }
    }
}

