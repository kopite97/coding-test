package hash;

/**
 * https://www.acmicpc.net/problem/1764
 */

import java.io.*;
import java.util.*;
public class DBJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s,0);
        }

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if(map.containsKey(s)){
                list.add(s);
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(String s : list){
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
