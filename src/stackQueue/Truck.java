package stackQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */

import java.io.*;
import java.util.*;
public class Truck {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        System.out.println(solution(bridge_length, weight, truck_weights));


    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < bridge_length; i++) {
            dq.offer(0);
        }

        int sum =0;
        int second = 0;
        int index =0;

        while (!dq.isEmpty()) {

            second++;
            sum -= dq.pollFirst();

            if (index < truck_weights.length) {

                if(sum + truck_weights[index] <= weight){
                    int truck = truck_weights[index++];
                    dq.offerLast(truck);
                    sum+=truck;
                } else{
                    dq.offerLast(0);
                }
            }
        }
        return second;
    }
}
