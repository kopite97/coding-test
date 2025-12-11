package array;

/**
 * https://www.acmicpc.net/problem/2738
 */

import java.io.*;
import java.util.*;

public class PickTwoAdd {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] numbers){

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers.length;j++){

                if(i ==j) continue;
                int sum = numbers[i]+numbers[j];
                set.add(sum);
            }
        }

        return set.stream().sorted().mapToInt(i->i).toArray();

    }

    public static int[] solution2(int[] numbers){

        boolean[] visited = new boolean[201];

        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                int sum = numbers[i] + numbers[j];
                visited[sum] = true;
            }
        }

        int count =0;
        for (boolean b : visited) {
            if (b) count++;
        }

        int[] answers = new int[count];
        int index =0;
        for(int i=0;i<visited.length;i++){
            if(visited[i] == true){
                answers[index++] = i;
            }
        }
        return answers;
    }
}
