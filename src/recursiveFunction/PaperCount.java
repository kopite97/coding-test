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
        // 1. 현재 구역이 모두 같은 숫자인지 검사
        if (checkIsSame(x, y, n)) {
            int num = arr[x][y];
            result[num+1]++;
            return;
        }

        // 2. 같지 않다면 9등분 하여 재귀 호출
        int newSize = n/3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dfs(x+(i*newSize),y+(j*newSize),newSize);
            }
        }


    }

    static boolean checkIsSame(int x, int y, int n) {
        int standard = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(arr[i][j] != standard) {
                    return false;
                }
            }
        }
        return true;
    }
}
