package tree;

/**
 * https://www.acmicpc.net/problem/2178
 */

import java.io.*;
import java.util.*;

public class MazeNavigation {
    static int[][] graph;
    static int N,M;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int num = str.charAt(j) - '0';
                graph[i][j] = num;
            }
        }

        bfs(0,0);
        System.out.println(graph[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {

            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX <0 || nextY <0 || nextX >=N || nextY >=M) continue;

                if(graph[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;

                    graph[nextX][nextY] = graph[currentX][currentY] + 1;

                    queue.add(new int[]{nextX, nextY});
                }

            }

        }



    }

}
