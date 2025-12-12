package linkedllist;

/**
 * https://www.acmicpc.net/problem/2346
 */

import java.util.*;
import java.io.*;

public class PopBalloon {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Deque<Balloon> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            deque.add(new Balloon(i + 1, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1");

        int v = deque.pollFirst().value;
        while(!deque.isEmpty()){
            Balloon balloon;
            if (v > 0) {

                for(int k=0;k<v-1;k++){
                    deque.addLast(deque.pollFirst());
                }
                balloon = deque.pollFirst();

            } else {

                for (int k = 0; k < Math.abs(v) - 1; k++) {
                    deque.addFirst(deque.pollLast());
                }
                balloon = deque.pollLast();
            }
            v = balloon.value;
            sb.append(" " + balloon.index);
        }

        System.out.println(sb);

    }
}

class Balloon{
    int index;
    int value;

    public Balloon(int index, int value){
        this.index = index;
        this.value = value;
    }
}
