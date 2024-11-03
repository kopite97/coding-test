package com.sparta.club99.day7;

import java.util.Scanner;

public class pragrammers {
    /**
     * 문제
     * 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는,
     * 길이 5 이하의 모든 단어가 수록되어 있습니다.
     * 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
     *
     * 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return
     * 하도록 solution 함수를 완성해주세요.
     */

    /**
     * 제한사항
     * word의 길이는 1 이상 5 이하입니다.
     * word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
     */

    public static int index = 1;
    public static String VOWELS ="AEIOU";
    public static void main(String[] args){
        System.out.println("프로그램 시작");
        Scanner sc = new Scanner(System.in);
        solution2(sc.nextLine());
        sc.close();
    }

    public static int solution1(String word){
        int position = 0;
        //final String VOWELS = "AEIOU";
        final int[] WEIGHTS = {781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = VOWELS.indexOf(ch);
            position += index * WEIGHTS[i] + 1;
        }

        return position;
    }

    public static int solution2(String word){
        int answer =0;

        findIndex(word,"",0);
        answer = index;

        System.out.println("answer : "+answer);
        return answer;
    }

    public static void findIndex(String word,String current,int depth){
        if(current.equals(word)){
            return;
        }

        if(current.length()>=5){
            return;
        }

        for(int i=0;i<VOWELS.length();i++){
            index++;
            findIndex(word,current+VOWELS.charAt(i),depth+1);
        }

    }

}
