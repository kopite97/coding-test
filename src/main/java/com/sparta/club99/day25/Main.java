package com.sparta.club99.day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dice = new int[n][6];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<6;j++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] opposite = {5,3,4,1,2,0};

        int maxSum =0;

        for(int i=0;i<6;i++){

            int bot = dice[0][i];
            int top = dice[0][opposite[i]];
            int sum = getMaxSide(dice[0], top, bot);

            for(int j=1;j<n;j++){
                bot = top;
                for (int h = 0; h < 6; h++) {
                    if(dice[j][h] == bot){
                        top = dice[j][opposite[h]];
                        break;
                    }
                }
                sum += getMaxSide(dice[j], top, bot);
            }
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }

    public static int getMaxSide(int[] dice,int top,int bot){
        int max =0;
        for(int num : dice){
            if(num != top && num!=bot){
                max = Math.max(max, num);
            }
        }
        return max;
    }

}
