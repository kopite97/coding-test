package graph;

import java.util.*;

public class LinkIsland_Kruskal {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs,(a,b)->a[2]-b[2]);

        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int weight =  costs[i][2];

            if(find(a) != find(b)){
                union(a,b);
                answer +=  weight;
            }
        }

        return answer;
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        parent[rootA] = rootB;
    }
}
