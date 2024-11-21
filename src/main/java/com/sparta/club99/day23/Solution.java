package com.sparta.club99.day23;

import java.util.HashSet;

public class Solution {

    public static HashSet<Integer> numberSet = new HashSet<>();
    public int solution(String numbers){
        generateNumbers("", numbers);

        int answer =0;

        for(int num : numberSet){
            if(checkPrime(num)){
                answer++;
            }
        }

        return answer;
    }

    public boolean checkPrime(int num){
        if(num<=1){
            return false;
        }

        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public void generateNumbers(String num,String remaining){

        if (!num.isEmpty()) {
            numberSet.add(Integer.parseInt(num));
        }

        for(int i=0;i<remaining.length();i++){
            generateNumbers(num + remaining.charAt(i),
                remaining.substring(0, i) + remaining.substring(i + 1));
        }

    }

}
