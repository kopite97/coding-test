package stackQueue;


import java.io.*;
import java.util.*;

public class PS {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            String ps = br.readLine().trim();
            Deque<Character> stack =  new ArrayDeque<>();
            boolean isVPS = true;
            for (int j = 0; j < ps.length(); j++) {
                if(ps.charAt(j) == '('){
                    stack.push('(');
                } else if(ps.charAt(j) == ')'){
                    if(!stack.isEmpty()){
                        stack.pop();
                    } else{
                        isVPS = false;
                        break;
                    }
                }
            }
            if(isVPS){
                if(stack.isEmpty()) {
                    sb.append("YES");
                } else{
                    sb.append("NO");
                }
            } else{
                sb.append("NO");
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

    /**
     * Stack으로 구현했는데 단순히 괄호의 종류가 단 한쌍뿐이라서 그냥 int로 해도 됨
     */
}
