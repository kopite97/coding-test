package stackQueue;

import java.io.*;
import java.util.*;

public class StackSequenceRefact {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int count = 1;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            while (target >= count) {
                stack.offerLast(count++);
                sb.append("+\n");
            }

            if (stack.peekLast() == target) {
                stack.pollLast();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }

        }
        System.out.println(sb);

    }
}
