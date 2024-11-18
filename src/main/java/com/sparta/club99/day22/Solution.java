package com.sparta.club99.day22;

public class Solution {

    public static int maxCount =0;
    public int solution(int k, int[][] dungeons) {
        int answer =-1;

        boolean[] visited = new boolean[dungeons.length];
        calcCost(k,dungeons,visited,0);
        answer = maxCount;

        return answer;
    }

    public void calcCost(int k,int[][] dungeons,boolean[] visited,int count){
        maxCount = Math.max(maxCount,count);

        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && k>= dungeons[i][0]){
                visited[i] = true;
                calcCost(k-dungeons[i][1],dungeons,visited,count+1);
                visited[i] = false;
            }

        }
    }

}
