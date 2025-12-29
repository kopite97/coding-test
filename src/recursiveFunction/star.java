package recursiveFunction;


/**
 * https://www.acmicpc.net/problem/2447
 */

import java.io.*;

public class star {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for(int j=0;j<n;j++){
                arr[i][j] = ' ';
            }
        }

        star(0, 0, n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    static void star(int x, int y, int m) {
        if (m == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = m/3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (i == 1 && j == 1) {
                    continue;
                }

                star( x + (i*size), y + (j*size), size);

            }
        }
    }
}
