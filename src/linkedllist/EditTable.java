package linkedllist;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/81303
 */

import java.util.*;

public class EditTable {
    public static void main(String[] args) {

        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(solution(n, k, cmd));
    }

    public static String solution(int n, int k, String[] cmd) {

        int[] pre = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            pre[i] = i-1;
            next[i] = i+1;
        }
        next[n-1] = -1;

        Stack<Integer> deleted = new Stack<>();

        for(String command : cmd) {
            char c = command.charAt(0);

            if (c == 'U') {
                int x = Integer.parseInt(command.substring(2));
                while (x-- > 0) {
                    k = pre[k];
                }
            } else if (c == 'D') {
                int x = Integer.parseInt(command.substring(2));
                while (x-- > 0) {
                    k = next[k];
                }
            } else if (c == 'C') {

                // k의 이전 노드와 다음 노드 확인
                int prev = pre[k];
                int nxt = next[k];

                // 1. 이전 노드(prev)의 '다음'을 k의 '다음'으로 연결
                if (prev != -1) { // 맨 첫 노드가 아니라면
                    next[prev] = nxt;
                }

                // 2. 다음 노드(nxt)의 '이전'을 k의 '이전'으로 연결
                if (nxt != -1) { // 맨 끝 노드가 아니라면
                    pre[nxt] = prev;
                }

                // 3. 삭제된 노드(k)를 스택에 저장 (복구를 위해)
                deleted.push(k);

                // 4. 커서(k)이동 처리
                if (nxt != -1) {
                    k = nxt;
                } else {
                    k = prev;
                }

            } else if (c == 'Z') {
                int restore = deleted.pop();

                // 연결 복구 (배열 값 수정)
                int prev = pre[restore];
                int nxt = next[restore];

                // 1. 이전 노드 복구
                if (prev != -1) {
                    next[prev] = restore;
                }
                // 2. 다음 노드 복구
                if (nxt != -1) {
                    pre[nxt] = restore;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("O".repeat(n));

        while (!deleted.isEmpty()) {
            sb.setCharAt(deleted.pop(), 'X');
        }

        return sb.toString();
    }
}
