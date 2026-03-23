package tree;

import java.io.*;
import java.util.*;

public class Cabbage {
    static int[] DX = {0, 0, -1, 1};
    static int[] DY = {1, -1, 0, 0};
    static int M, N;
    static int count;
    static int[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t>0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M =  Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int k =  Integer.parseInt(st.nextToken());

            graph = new  int[M][N];
            visited = new boolean[M][N];
            count = 0;

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for(int j =0 ; j < N; j++){
                    if(graph[i][j] == 1 && !visited[i][j]){
                        bfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);

            t--;
        }

    }

    static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if(nextX <0 || nextY <0 || nextX >=M || nextY >=N) continue;

                if(graph[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;

                    queue.add(new int[] {nextX, nextY});
                }
            }
        }
    }
}
