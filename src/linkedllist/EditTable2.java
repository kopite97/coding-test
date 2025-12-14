package linkedllist;

import java.util.Stack;

public class EditTable2 {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        System.out.println(solution(n, k, cmd));

    }

    static String solution(int n, int k, String[] cmd) {

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                nodes[i].prev = nodes[i - 1];
            }

            if (i < n - 1) {
                nodes[i].next = nodes[i + 1];
            }
        }

        Node cursor = nodes[k];

        Stack<Node> deleted =  new Stack<Node>();

        for (String command : cmd) {
            char c = command.charAt(0);

            if (c == 'U') {
                int x = Integer.parseInt(command.substring(2));
                while (x-- > 0) {
                    cursor = cursor.prev;
                }
            } else if  (c == 'D') {

                int x = Integer.parseInt(command.substring(2));
                while (x-- > 0) {
                    cursor = cursor.next;
                }
            } else if (c == 'C') {
                deleted.push(cursor);

                if (cursor.prev != null) {
                    cursor.prev.next = cursor.next;
                }

                if (cursor.next != null) {
                    cursor.next.prev = cursor.prev;
                }

                if (cursor.next != null) {
                    cursor = cursor.next;
                } else{
                    cursor = cursor.prev;
                }

            } else if (c == 'Z') {
                Node restore = deleted.pop();

                Node prevNode = restore.prev;
                Node nextNode = restore.next;

                if(prevNode != null) {
                    prevNode.next = restore;
                }

                if (nextNode != null) {
                    nextNode.prev = restore;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("O".repeat(n));

        while(!deleted.isEmpty()) {
            sb.setCharAt(deleted.pop().index,'X');
        }

        return sb.toString();
    }

    static class Node{
        int index;
        Node prev;
        Node next;

        public Node(int index) {
            this.index = index;
        }
    }
}
