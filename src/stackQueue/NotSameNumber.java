package stackQueue;

import java.util.*;

public class NotSameNumber {
    public static void main(String[] args) {

        int[] arr = {1,1,3,3,0,1,1};
        int[] answer = solution(arr);
        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x);
        }
        System.out.println(sb);

    }

    public static int[] solution(int[] arr) {

        List<Integer> list = new ArrayList<>();

        int prevNum = -1;

        for(int i=0;i<arr.length;i++){
            int x = arr[i];
            if (list.isEmpty() || x != prevNum) {
                list.add(x);
                prevNum = x;
            }
        }

        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }

        return result;
    }
}
