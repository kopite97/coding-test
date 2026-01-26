package hash;

/**
 * https://www.acmicpc.net/problem/1620
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Pocketmon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> dic1 = new HashMap<>();
        Map<String,Integer> dic2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String pocketmon = br.readLine();
            dic1.put(i, pocketmon);
            dic2.put(pocketmon, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String v = br.readLine();
            if (isInteger(v)) {
                int num = Integer.parseInt(v);
                sb.append(dic1.get(num)).append("\n");
            }else{
                sb.append(dic2.get(v)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isInteger(String v){
        try{
            Integer.parseInt(v);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
