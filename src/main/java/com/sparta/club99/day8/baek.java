package com.sparta.club99.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek {

    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int[] depth;

    public static void main(String[] args) throws IOException {
        /**
         * 문제
         * 우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.
         * 이러한 촌수는 다음과 같은 방식으로 계산된다.
         * 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다.
         * 예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고,
         * 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
         *
         * 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때,
         * 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
         */

        /**
         * 입력
         * 사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다.
         * 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고,
         * 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다.
         * 그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다.
         * 넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다.
         * 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
         *
         * 각 사람의 부모는 최대 한 명만 주어진다.
         */

        /**
         * 출력
         * 입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다.
         * 어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다.
         * 이때에는 -1을 출력해야 한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        depth = new int[n+1];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = bfs(one, two);
        System.out.println(answer);
    }

    public static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        depth[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return depth[current];
            }

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[current] + 1;
                    queue.add(next);
                }
            }
        }

        return -1;
    }
}

