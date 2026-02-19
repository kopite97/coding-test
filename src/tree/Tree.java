package tree;

/**
 * https://www.acmicpc.net/problem/1068
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tree {
    static Node[] tree;
    static int count;
    public static void main(String[] args) throws  IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new Node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new Node(i);
        }

        int root = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            if(v == -1) {
                root = i;
                continue;
            }

            Node parent = tree[v];
            Node child = tree[i];
            parent.children.add(child);
        }

        int remove = Integer.parseInt(br.readLine());
        removeNode(tree[remove]);

        count =0;

        dfs(tree[root]);

        System.out.println(count);
    }

    public static void dfs(Node node) {
        if(node.isDeleted) return;

        boolean isLeaf = true;

        for(Node child : node.children) {
            if (!child.isDeleted) {
                isLeaf = false;
                dfs(child);
            }
        }

        if (isLeaf) {
            count++;
        }

    }

    public static void removeNode(Node node) {
        if (node.children.isEmpty()) {
            node.isDeleted = true;
            return;
        }

        for(Node child : node.children) {
            removeNode(child);
        }
        node.isDeleted = true;
        node.children.clear();
    }

    static class Node{
        List<Node> children;
        int v;
        boolean isDeleted;

        public Node(int v){
            this.v=v;
            children = new ArrayList<>();
            isDeleted = false;
        }
    }
}
