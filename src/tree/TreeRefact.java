package tree;

/**
 * https://www.acmicpc.net/problem/1068
 */

import java.io.*;
import java.util.*;
public class TreeRefact {
    static int DeleteNode;
    static int LeafCount;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < n; i++) {

            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        DeleteNode = Integer.parseInt(br.readLine());

        if (DeleteNode == root) {
            System.out.println(0);
            return;
        }

        LeafCount = 0;
        dfs(root);

        System.out.println(LeafCount);
    }

    public static void dfs(int current) {
        int validChildrenCount =0 ;

        for(int child : tree[current]) {
            if (child == DeleteNode) {
                continue;
            }
            validChildrenCount++;
            dfs(child);
        }

        if (validChildrenCount == 0) {
            LeafCount++;
        }
    }
}
