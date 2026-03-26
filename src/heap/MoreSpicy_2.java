package heap;

import java.util.PriorityQueue;

public class MoreSpicy_2 {
    public static int solution(int[] scoville, int k) {
        int answer = 0;


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<scoville.length;i++) {
            pq.add(scoville[i]);
        }

        while (pq.peek() < k) {
            answer ++;
            if (pq.size() < 2) {
                return -1;
            }
            int minNum1 = pq.poll();
            int minNum2 = pq.poll();

            int newNum = minNum1 + (minNum2 * 2);
            pq.add(newNum);
        }

        return answer;
    }
}
