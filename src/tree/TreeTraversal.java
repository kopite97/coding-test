package tree;

/**
 * https://www.acmicpc.net/problem/1991
 */

import java.io.*;
import java.util.StringTokenizer;

public class TreeTraversal {
    static StringBuilder sb;
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new Node[26];
        for (int i = 0; i < 26; i++) {
            tree[i] = new Node((char) ('A' + i));
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node parent = tree[value - 'A'];
            if (left != '.') {
                parent.left = tree[left - 'A'];
            }
            if (right != '.') {
                parent.right = tree[right - 'A'];
            }
        }

        sb = new StringBuilder();
        preOrder(tree[0]);
        sb.append("\n");
        inOrder(tree[0]);
        sb.append("\n");
        postOrder(tree[0]);

        System.out.println(sb);
    }

    public static void preOrder(Node node) {
        if(node == null) return;
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node == null) return;

        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);

    }

    public static void postOrder(Node node) {
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }
}
class Node{
    Node left;
    Node right;
    char value;

    public Node(char value) {
        this.value = value;
        left = null;
        right = null;
    }
}
