package sort;

/**
 * https://www.acmicpc.net/problem/11650
 */

import java.io.*;
import java.util.*;

public class SortPos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();

        for (int key : keys) {
            List<Integer> list = map.get(key);
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                sb.append(key).append(" ").append(list.get(i)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
