package stackQueue;

import java.util.*;
import java.io.*;

public class Queueeeee {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            String cmd =br.readLine().trim();

            if (cmd.startsWith("push")) {
                int x = Integer.parseInt(cmd.substring(5).trim());
                queue.offerLast(x);
            } else if (cmd.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (cmd.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
            } else if (cmd.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
            }

        }

        System.out.println(sb);

    }
}
