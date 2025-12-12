package linkedllist;

import java.io.*;
import java.util.*;

public class JosephusProblem {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> list = new LinkedList<>();

        for(int i=1;i<=n;i++){
            list.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(list.size()>1)
        {
            for(int i=0;i<k-1;i++){
                list.offer(list.poll());
            }
            sb.append(list.poll()).append(", ");
        }

        sb.append(list.poll()).append(">");
        System.out.println(sb);
    }
}
