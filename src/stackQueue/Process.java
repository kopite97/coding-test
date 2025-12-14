package stackQueue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Process {
    public static void main(String[] args) throws IOException {

        int[] arr = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(arr,location));

    }

    public static int solution(int[] priorities,int location){

        Deque<Priority> dq =  new ArrayDeque<>();

        for(int i=0;i<priorities.length;i++){
            int priority = priorities[i];
            dq.add(new Priority(priority,i));
        }

        Arrays.sort(priorities);
        int pqIndex = priorities.length-1;

        int exeIndex = 0;
        while(true){

            // 1. 일단 큐를 뽑아
            Priority p =  dq.poll();

            // 2. 이제 우선순위를 확인하고 실행해
            if(priorities[pqIndex] > p.priority){ // 우선순위 낮음
                dq.offer(p);
            } else{ // 우선순위 높거나 같음
                pqIndex--;
                exeIndex++;
                if (location == p.index) {
                    break;
                }
            }
        }
        return  exeIndex;
    }

    static class Priority{
        int priority;
        int index;

        public Priority(int priority, int index){
            this.priority = priority;
            this.index = index;
        }
    }
}
