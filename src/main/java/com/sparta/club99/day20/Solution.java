package com.sparta.club99.day20;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] answers){


        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};

        int[] count = new int[3];

        for (int i=0;i<answers.length;i++){
            if(arr1[i%5] == answers[i]){
                count[0] +=1;
            }
            if(arr2[i%8] == answers[i]){
                count[1] +=1;
            }
            if(arr3[i%10] == answers[i]){
                count[2] +=1;
            }
        }

        // 3 ,2 ,4

        int max = count[0];
        for(int i=0;i<3;i++){
            if(max<=count[i]){
                max = count[i];
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for(int i=0;i<3;i++){
            if(max== count[i]){
                resultList.add(i+1);
            }
        }

        int[] result = new int[resultList.size()];
        for(int i=0;i<resultList.size();i++){
            result[i] = resultList.get(i);
        }

        return result;
    }
}
