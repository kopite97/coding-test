package heap;

import java.io.*;
import java.util.*;

public class SayMideum {
    static PriorityQueue<Integer> MinPq;
    static PriorityQueue<Integer> MaxPq;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        MinPq = new PriorityQueue<>();
        MaxPq = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int minSize = MinPq.size();
            int maxSize = MaxPq.size();

            if (minSize >= maxSize) {
                MaxPq.add(num);
            } else {
                MinPq.add(num);
            }

            if(!MaxPq.isEmpty() && !MinPq.isEmpty()){
                int currentMid = MaxPq.peek();
                int currentMin = MinPq.peek();
                if(currentMid > currentMin){
                    int large = MaxPq.poll();
                    int small = MinPq.poll();

                    MaxPq.add(small);
                    MinPq.add(large);
                }
            }

            sb.append(MaxPq.peek()).append("\n");
        }

        System.out.println(sb);

    }
}
