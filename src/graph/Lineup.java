package graph;

import java.util.*;
import java.io.*;

public class Lineup {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] inDegree;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st  = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        inDegree = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            inDegree[i] = 0;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            inDegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");
            for(int next : graph.get(current)) {
                inDegree[next]--;
                if(inDegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        System.out.println(sb);

    }
}
