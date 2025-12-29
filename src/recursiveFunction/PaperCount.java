package recursiveFunction;

/**
 * https://www.acmicpc.net/problem/1780
 */

import java.io.*;
import java.util.StringTokenizer;

public class PaperCount {
    static int[][] arr;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        result = new int[3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int var : result) {
            sb.append(var).append("\n");
        }
        System.out.println(sb);

    }

    static void dfs(int x, int y, int n) {
        if (n == 1) {
            int m = arr[x][y];
            if (m == -1) {
                result[0] +=1;
            } else if (m == 0) {
                result[1] +=1;
            } else if (m == 1) {
                result[2] +=1;
            }

            return;
        }

        int num = arr[x][y];

        boolean isSame = true;
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if(num != arr[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }

        if (!isSame) {
            int newSize = n/3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    dfs(x + i * newSize, y + j * newSize, newSize);
                }
            }
            return;
        }

        if (num == -1) {
            result[0] +=1;
        } else if (num == 0) {
            result[1] +=1;
        } else if (num == 1) {
            result[2] +=1;
        }

    }
}
