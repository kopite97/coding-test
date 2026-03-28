package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiscController {
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{

            int startTimeA = a[0];
            int StartTimeB = b[0];
            int processingTimeA = a[1];
            int processingTimeB = b[1];
            int processingNumberA = a[2];
            int processingNumberB = b[2];

            // 1. 작업의 소요시간이 짧은 것.
            if(processingTimeA != processingTimeB){
                return processingTimeA -   processingTimeB;
            }

            // 2. 작업의 요청 시각이 빠른 것.

            if(startTimeA != StartTimeB){
                return startTimeA - StartTimeB;
            }

            // 3. 작업의 번호가 작은 것.

            return  processingNumberA - processingNumberB;
        });

        int[][] newJobs = new int[jobs.length][3];
        for (int i = 0; i < jobs.length; i++) {
            newJobs[i][0] = jobs[i][0];
            newJobs[i][1] = jobs[i][1];
            newJobs[i][2] = i;
        }

        Arrays.sort(newJobs, Comparator.comparingInt(a -> a[0]));


        int jobIndex = 0;
        int time = 0;
        int count = 0;

        while(count < jobs.length){
            while ( jobIndex <= newJobs.length - 1 && time >= newJobs[jobIndex][0]) {
                pq.add(newJobs[jobIndex++]);
            }

            if (pq.isEmpty() && jobIndex <= newJobs.length - 1) {
                time = newJobs[jobIndex][0];
                continue;
            }

            int[] currentJob = pq.poll();
            time += currentJob[1];
            int returnTime = time -  currentJob[0];
            answer += returnTime;
            count++;

        }

        return answer / jobs.length;
    }
}
