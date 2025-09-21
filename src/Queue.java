import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder out = new  StringBuilder();


        for (int i = 0; i < n; i++) {

            String line = br.readLine().trim();

            if (line.startsWith("push")) {
                int x = Integer.parseInt(line.substring(5).trim());
                queue.offerLast(x);
            } else if ("pop".equals(line)) {
                out.append(queue.isEmpty() ? -1 : queue.pollFirst()).append('\n');
            } else if ("size".equals(line)){
                out.append(queue.size()).append('\n');
            } else if ("empty".equals(line)) {
                out.append(queue.isEmpty() ? 1 : 0).append('\n');
            } else if ("front".equals(line)) {
                out.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
            } else if ("back".equals(line)) {
                out.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
            }
        }

        System.out.print(out);

    }
}
