package linkedllist;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/81303
 */

import java.util.*;
import java.io.*;

public class EditTable {
    public static void main(String[] args) throws IOException {

        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        String answer = solution(n, k, cmd);

        System.out.println(answer);

    }

    public static String solution(int n,int k , String[] cmd){


        LinkedList<Integer> table = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            table.add(i);
        }

        Stack<Integer> undoTable = new Stack<>();
        ListIterator<Integer> iter = table.listIterator(k);

        int currentIndex = k;

        for (int i = 0; i < cmd.length; i++) {
            StringTokenizer st = new StringTokenizer(cmd[i]);

            char c = st.nextToken().charAt(0);

            if (c == 'U') {
                int x = Integer.parseInt(st.nextToken());

                for (int j = 0; j < x ; j++) {
                    if (iter.hasPrevious()) {
                        currentIndex = iter.previous();
                    }
                }

            } else if (c == 'D') {
                int x = Integer.parseInt(st.nextToken());

                for (int j = 0; j < x ; j++) {
                    if (iter.hasNext()) {
                        currentIndex = iter.next();
                    }
                }

            } else if (c == 'C') {

                int removeIndex = currentIndex;
                iter.remove();
                if (iter.hasPrevious()) {
                    currentIndex = iter.previous();
                }


            } else { // c == 'Z'

                int undoIndex = undoTable.pop();
                table.add(undoIndex, undoIndex);

            }
        }

        StringBuilder sb = new StringBuilder();


        return null;
    }

}
