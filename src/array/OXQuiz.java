package array;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/8958
 */

public class OXQuiz {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            String ox = br.readLine();
            int score = 0;
            int sum = 0;
            for(int j=0;j<ox.length();j++){
                if (ox.charAt(j) == 'O') {
                    score ++;
                    sum += score;
                }
                else score =0;
            }

            result[i] = sum;
        }

        for(int i=0;i<n;i++){
            System.out.println(result[i]);
        }

    }
}
