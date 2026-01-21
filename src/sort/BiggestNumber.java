package sort;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */

import java.util.ArrayList;
import java.util.List;

public class BiggestNumber {
    public static void main(String[] args) {

        int[] strs= {2600,2601,2701};
        System.out.println(solution(strs));

    }

    public static String solution(int[] numbers){
        String answer = "";

        List<String> list = new ArrayList<>();

        for (int n : numbers) {
            String s = Integer.toString(n);
            list.add(s);
        }

        list.sort((a, b) -> (b+a).compareTo(a+b));

        if (list.get(0).equals("0")) {

            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s);
        }

        answer = sb.toString();

        return answer;
    }
}
