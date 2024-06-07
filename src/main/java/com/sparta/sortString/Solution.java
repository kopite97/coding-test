package com.sparta.sortString;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer;

        answer =Arrays.stream(strings).sorted(Comparator.comparing((String x)->x.charAt(n)).thenComparing(Comparator.naturalOrder())).toArray(String[]::new);
      return answer;
    }
}