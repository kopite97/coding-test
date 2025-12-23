package stackQueue;

/**
 * https://www.acmicpc.net/problem/2493
 */

import java.io.*;
import java.util.*;

public class Tower {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                int index = stack.pop();
            }

            if(stack.isEmpty()){
                result[i] = 0;
            } else{
                result[i] = stack.peek() +1;
            }
            stack.push(i);
        }


        StringBuilder sb = new StringBuilder();
        for (int index : result) {
            sb.append(index).append(" ");
        }

        System.out.println(sb);

    }
}
