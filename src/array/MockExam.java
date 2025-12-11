package array;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */

public class MockExam {
    public static void main(String[] args) {

        int[] sol = {1,3,2,4,2};
        int[] answer = solution(sol);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);

    }

    public static int[] solution(int[] answers){

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {

            if(answers[i] == arr1[i%arr1.length]) scores[0]++;
            if(answers[i] == arr2[i%arr2.length]) scores[1]++;
            if(answers[i] == arr3[i%arr3.length]) scores[2]++;

        }

        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        List<Integer> answerList = new ArrayList<>();
        for(int i=0;i<3;i++){
            if (scores[i] == maxScore) {
                answerList.add(i + 1);
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray();

    }
}
