package stackQueue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Card2 {
    public static void main (String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            deque.offer(i+1);
        }

        while (deque.size() !=1) {

            deque.pollFirst();

            int x = deque.pollFirst();
            deque.offerLast(x);
        }

        System.out.println(deque.pollLast());
    }
}
