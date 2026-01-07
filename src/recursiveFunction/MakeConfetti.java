package recursiveFunction;

/**
 * https://www.acmicpc.net/problem/2630
 */

import java.io.*;
import java.util.StringTokenizer;

public class MakeConfetti {
    static int[][] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        result = new int[2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, n);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static void dfs(int x,int y,int n) {

        if (n == 1) {
            if(arr[x][y] == 0) {
                result[0]++;
            }
            else{
                result[1]++;
            }
            return;
        }

        int num = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != num) {
                    int newSize = n/2;
                    // 왼쪽 위, 왼쪽 아래, 오른쪽 위,오른쪽 아래
                    // 방향으로 보내기
                    dfs(x, y, newSize); // 왼쪽 위
                    dfs(x,y+newSize,newSize); //왼쪽 아래
                    dfs(x + newSize, y , newSize); // 오른쪽 위
                    dfs(x+ newSize, y+newSize, newSize); //오른쪽 아래
                    return;
                }
            }
        }

        if (num == 0) {
            result[0]++;
        }
        else{
            result[1]++;
        }

    }
}
