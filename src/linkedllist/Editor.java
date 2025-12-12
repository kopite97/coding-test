package linkedllist;

/**
 * https://www.acmicpc.net/problem/1406
 */

import java.io.*;
import java.util.*;

public class Editor {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim();

        int m = Integer.parseInt(br.readLine().trim());

        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> tempStack = new ArrayDeque<>();

        for(int i=0;i<word.length();i++){
            stack.push(word.charAt(i));
        }

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String firstCommand = st.nextToken();
            if (firstCommand.equals("L")){
                if(stack.isEmpty()) continue;
                tempStack.push(stack.pop());

            }else if (firstCommand.equals("D")){
                if(tempStack.isEmpty()) continue;
                stack.push(tempStack.pop());

            }else if (firstCommand.equals("B")){
                if(stack.isEmpty()) continue;

                stack.pop();

            }else if (firstCommand.equals("P")){
                char insert = st.nextToken().charAt(0);
                stack.push(insert);
            }
        }

        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        int stackSize = stack.size();
        for(int i=0;i<stackSize;i++){
            sb.append(stack.pop());
        }

        sb.reverse();
        System.out.println(sb);
    }
}
