package heap;

import java.io.*;

public class AbsHeap {
    static int[] heap;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        heap = new int[n + 1];
        size = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (size >= 1) {
                    sb.append(poll()).append("\n");

                }else{
                    sb.append(0).append("\n");
                }
            } else {
                add(num);
            }
        }

        System.out.println(sb);
    }

    static int poll() {
        if(size == 0) return 0;

        int minNum = heap[1];
        int current = 1;
        heap[1] = heap[size];
        heap[size] = 0;
        size--;
        while (current * 2 <= size) {
            int leftchild =  current *2;
            int rightchild =  current *2 +1;
            int smallChild = leftchild;

            if (rightchild <= size && compare(leftchild, rightchild)) {
                smallChild = rightchild;
            }

            if (compare(smallChild, current)) {
                break;
            }
            swap(current, smallChild);
            current = smallChild;
        }

        return minNum;
    }

    static void add(int addNum) {

        heap[++size] = addNum;

        int current = size;

        while (current > 1 && compare(current/2, current)) {
            swap(current, current/2);
            current = current/2;
        }

    }

    // 절댓값이 a가 더 크다면 true
    static boolean compare(int a, int b) {

        int a1 = heap[a];
        int b1 = heap[b];

        int absA = Math.abs(a1);
        int absB = Math.abs(b1);

        if (absA == absB) {
            return a1 > b1;
        }

        return absA >  absB;
    }

    static void swap(int a, int b) {

        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
