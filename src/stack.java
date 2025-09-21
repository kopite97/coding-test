import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class stack {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();

            if (line.startsWith("push")) {
                // "push X" 형태 -> X 파싱
                int x = Integer.parseInt(line.substring(5).trim());
                stack.push(x);
            } else if ("pop".equals(line)) {
                out.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
            } else if ("size".equals(line)) {
                out.append(stack.size()).append('\n');
            } else if ("empty".equals(line)) {
                out.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else if ("top".equals(line)) {
                out.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
            }
        }

        System.out.print(out);
    }
}
