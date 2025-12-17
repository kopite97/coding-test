package stackQueue;

import java.io.*;
import java.util.*;

public class StackSequence {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int count = 1;
        boolean isSuccess = false;

        while(true){
            if (index >= n) {
                isSuccess = true;
                break;
            }
            if(dq.isEmpty()){
                if (sequence[index] > count) {
                    dq.offerLast(count++);
                    sb.append("+").append("\n");
                } else if (sequence[index] == count) {
                    sb.append("+").append("\n");
                    sb.append("-").append("\n");
                    count++;
                    index++;
                } else{
                    System.out.println("NO");
                    break;
                }
            } else{
                if (sequence[index] > dq.peekLast()) {
                    dq.offerLast(count++);
                    sb.append("+").append("\n");
                } else if (sequence[index] == dq.peekLast()) {
                    dq.pollLast();
                    sb.append("-").append("\n");
                    index++;
                } else {
                    System.out.println("NO");
                    break;
                }

            }
        }
        if (isSuccess) {
            System.out.println(sb);

        }

    }
}
