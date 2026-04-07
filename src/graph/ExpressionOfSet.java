package graph;

import java.io.*;
import java.util.*;

public class ExpressionOfSet {
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new  StringTokenizer(br.readLine());
            int union =  Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (union == 0) {
                // 합집합
                union(a,b);
            } else {
                // 확인
                sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
            }
        }
        System.out.println(sb);

    }

    static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (a > b) {
                arr[rootA] = rootB;
            } else {
                arr[rootB] =  rootA;
            }
        }
    }
}
