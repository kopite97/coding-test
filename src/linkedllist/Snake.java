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


        /**
         * 0 : 빈공간
         * 1 : 사과
         * 2: 뱀
         */
        int[][] board = new int[n+1][n+1];

        for (int i = 0; i < apple; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 1;
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

        // 동 남 서 북
        int[] dr = {0, 1, 0, -1}; // row 변화량
        int[] dc = {1, 0, -1, 0}; // col 변화량
        int currentDir = 0; // 초기 방향 (오른쪽)

        int time = 0;
        int headR = 1, headC = 1;
        board[1][1] = 2;

        while(true){
            time ++;

            // 1. 다음 머리 위치 계산
            int nr = headR + dr[currentDir];
            int nc = headC + dc[currentDir];

            // 2. 종료 조건 (벽 충돌 or 자기 자신)
            if (nr < 1 || nc < 1 || nr > n || nc > n || board[nr][nc] == 2) {
                break;
            }

            // 3. 뱀 머리 이동
            if (board[nr][nc] == 0) {
                // 사과가 없다면
                Hevi tail = snake.pollLast();
                board[tail.x][tail.y] = 0;
            }

            // 머리 좌표 맵에 갱신
            snake.addFirst(new Hevi(nr, nc));
            board[nr][nc] = 2;
            headR = nr;
            headC = nc;

            // 4.방향 전환 시간인지 확인
            if (!commandQueue.isEmpty() && commandQueue.peek().second == time) {
                Command cmd = commandQueue.poll();
                if(cmd.direction == 'D'){
                    currentDir = (currentDir + 1)  % 4;
                } else {
                    currentDir = (currentDir -1 + 4) % 4;
                }
            }
        }

        System.out.println(time);

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