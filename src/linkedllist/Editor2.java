package linkedllist;

/**
 * https://www.acmicpc.net/submit/1406/101024604
 */

import java.util.*;
import java.io.*;

public class Editor2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim();

        int m = Integer.parseInt(br.readLine().trim());

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()){
            iter.next(); //커서 초기화 ( 맨 뒤로 이동)
        }


        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("L")) {
                if(!iter.hasPrevious()) continue;
                iter.previous();

            } else if (command.equals("D")) {
                if(!iter.hasNext()) continue;
                iter.next();

            } else if (command.equals("B")) {
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }

            } else if (command.equals("P")) {
                char c = st.nextToken().charAt(0);
                iter.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
