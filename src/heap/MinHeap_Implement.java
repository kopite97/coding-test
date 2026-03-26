package heap;

import java.io.*;

public class MinHeap_Implement {
    static int[] heap;
    static int size;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        heap = new int[n + 1];
        size = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (size < 1) {
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(poll()).append("\n");
            } else {
                add(num);
            }
        }

        System.out.println(sb);
    }

    static int poll() {

        int min = heap[1];
        heap[1] = heap[size];
        heap[size] = 0;
        size--;

        int current = 1;

        while (current * 2 <= size) { // 왼쪽 자식이 존재한다면 계속 실행
            
            int leftChild = current * 2;
            int rightChild = current * 2 + 1;

            int small = leftChild;

            if (rightChild <= size && heap[rightChild] < heap[leftChild]) {
                small = rightChild;
            }

            // 중단 조건 : 내가 자식보다 작다면
            if (heap[current] <= heap[small]) {
                break;
            }

            // 작지 않으면 교환
            swap(current, small);
            current = small;
        }

        return min;
    }

    static void add(int n){
        size++;

        heap[size] = n;

        int current = size;

        while (current >1 && heap[current] < heap[current/2] ) {
            swap(current / 2, current);
            current /=2;
        }
    }

    static void swap(int a, int b) {
        int temp =  heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
