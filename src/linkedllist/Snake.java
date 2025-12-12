package linkedllist;

/**
 * https://www.acmicpc.net/problem/3190
 */

import java.util.*;
import java.io.*;


public class Snake {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int apple = Integer.parseInt(br.readLine().trim());

        int[][] applePositions = new int[n][2];

        for (int i = 0; i < apple; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            applePositions[i][0] = x;
            applePositions[i][1] = y;
        }

        int commandCount = Integer.parseInt(br.readLine().trim());
        Queue<Command> commandQueue = new LinkedList<>();

        for (int i = 0; i < commandCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            commandQueue.offer(new Command(x, c));
        }

        Deque<Hevi> snake = new ArrayDeque<>();
        snake.add(new Hevi(1, 1));

        int[] vector = new int[2];
        vector[0] = 1;
        vector[1] = 0;

        boolean isNextCommand = true; // 명령어 큐에서 다음 command를 뽑을지

        int currentSecond = 0;
        int changeSecond = 0;
        char direction;
        while(true){
            currentSecond++;
            // 다음 명령 뽑을지
            if(isNextCommand){
                // 명령이 남아 있다면
                if (!commandQueue.isEmpty()) {
                    Command newCommand = commandQueue.poll();
                    isNextCommand = false;
                    changeSecond = newCommand.second;
                    direction = newCommand.direction;
                }
            }

            // 특정 시간이 지났는지
            if(currentSecond >= changeSecond){
                // 지났으면 방향 전환

                /**
                 * (1,0) => 오른쪽
                 * (0,1) => 아래
                 * (-1,0) => 왼쪽
                 * (0,-1) => 위쪽
                 */


                // 새 명령 뽑기
                isNextCommand = true;
            }

            // 지나지 않았으면 진행 방향 그대로


            // 게임 오버 체크
        }



    }
}

class Command{
    int second;
    char direction;

    public Command(int second, char direction){
        this.second = second;
        this.direction = direction;
    }
}

class Hevi{

    int x;
    int y;

    public Hevi(int x, int y){
        this.x = x;
        this.y = y;
    }

}