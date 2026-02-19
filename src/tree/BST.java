package tree;

/**
 * https://www.acmicpc.net/problem/5639
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    static StringBuilder Sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        Sb = new StringBuilder();
        Queue<Integer> buffer = new LinkedList<>();

        while ((str = br.readLine()) != null) {
            buffer.add(Integer.parseInt(str));
        }

        int rootNum = buffer.poll();
        Node root = new Node(rootNum);

        while(!buffer.isEmpty()) {
            int current = buffer.poll();
            root.insert(current);
        }



        System.out.println(Sb);

    }

    public static void postOrder(Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        Sb.append(node.data).append("\n");
    }

    static class Node{
        int data;
        Node left;
        Node right;

        Node (int num){
            data = num;
        }

        void insert(int n){
            if (n < data) { // 들어온 수가 작다면
                if (this.left == null) {
                    this.left = new Node(n);
                }else{
                    this.left.insert(n);
                }
            }else{
                if (this.right == null) {
                    this.right = new Node(n);
                }else{
                    this.right.insert(n);
                }
            }
        }

    }

}
