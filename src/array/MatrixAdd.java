package array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2738
 */

public class MatrixAdd {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String size = br.readLine();
        StringTokenizer stoken = new StringTokenizer(size);

        int n = Integer.parseInt(stoken.nextToken());
        int m = Integer.parseInt(stoken.nextToken());

        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int result = a[i][j] + Integer.parseInt(st.nextToken());
                sb.append(result).append(" ");
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}
