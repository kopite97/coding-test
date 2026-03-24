package tree;

import java.io.*;
import java.util.*;


public class Tomato {
    static int M,N;
    static int[][] graph;
    static boolean[][] visited;
    static int count;
    static int[] DX = {0, 0, -1, 1};
    static int[] DY = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[M][N];
        visited = new boolean[M][N];
        count = 0;

        Queue<int[]> q =  new LinkedList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n =  Integer.parseInt(st.nextToken());
                graph[j][i] = n;

                if(n == 1){
                    q.add(new int[]{j,i});
                }
            }
        }

        bfs(q);

        int max =0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int n = graph[i][j];
                if (n == 0) {
                    System.out.println(-1);
                    return;
                }
                if (max < n) {
                    max = n;
                }
            }
        }

        System.out.println(max-1);
    }

    static void bfs(Queue<int[]> q) {

        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentX =  current[0];
            int currentY =  current[1];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if(nextX <0 || nextY <0 || nextX>=M || nextY>=N) continue;

                if (!visited[nextX][nextY] && graph[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    graph[nextX][nextY] = graph[currentX][currentY] + 1;
                    q.add(new int[]{nextX, nextY});
                }
            }

        }

    }
}
