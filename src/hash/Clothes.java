package hash;

import java.util.*;

public class Clothes {
    public static void main(String[] args) {

    }

    public int solution(String[][] clothes) {

        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            String k = clothes[i][1];
            map.put(k, map.getOrDefault(k, 0) + 1);
        }


        int answer = 1;
        for (var cnt : map.values()) {
            answer *= (cnt + 1);
        }

        return answer -1;
    }
}
