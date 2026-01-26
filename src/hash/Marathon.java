package hash;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */

import java.util.*;

public class Marathon {
    public static void main(String[] args) {

    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<participant.length;i++){
            String s = participant[i];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(int i=0;i<completion.length;i++){
            String s = completion[i];
            if(map.containsKey(s)){
                int cnt = map.get(s);
                cnt = cnt - 1;
                if (cnt <= 0) {
                    map.remove(s);
                }else{
                    map.put(s, cnt);
                }
            }else{
                return s;
            }
        }


        if (!map.isEmpty()) {
            Set<String> strings = map.keySet();
            return strings.iterator().next();
        }


        return "";
    }
}
