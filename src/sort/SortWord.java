    package sort;

    /**
     * https://www.acmicpc.net/problem/1181
     */

    import java.io.*;
    import java.util.*;

    public class SortWord {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            List<String>[] arr = new ArrayList[51];

            for (int i = 0; i < 50; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i <=50; i++) {
                String word = br.readLine();
                int length = word.length();

                arr[length].add(word);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 50; i++) {
                if (!arr[i].isEmpty()) {

                    Set<String> set = new HashSet<>(arr[i]);
                    List<String> sorted = new ArrayList<>(set);

                    Collections.sort(sorted);
                    for (String word : sorted) {
                        sb.append(word).append("\n");
                    }
                }
            }
            System.out.println(sb);
        }
    }
