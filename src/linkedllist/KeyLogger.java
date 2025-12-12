package linkedllist;

/**
 * https://www.acmicpc.net/problem/5397
 */

import java.io.*;
import java.util.*;

public class KeyLogger {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());

        for(int i=0;i<testCase;i++){
            String pw = br.readLine().trim();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            StringBuilder sb = new StringBuilder();

            for(int j=0;j<pw.length();j++){
                char c = pw.charAt(j);
                if(c == '<'){
                    if(iter.hasPrevious()){
                        iter.previous();
                    }
                } else if (c == '>') {
                    if (iter.hasNext()) {
                        iter.next();
                    }

                } else if (c == '-') {
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(c);
                }
            }

            for (Character c : list) { // LinkedList는 반드시 내부적으로 iterator를 사용하는 반복문 사용
                sb.append(c);
            }
            System.out.println(sb);
        }


    }
}
