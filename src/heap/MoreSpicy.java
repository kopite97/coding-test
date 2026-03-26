package heap;

public class MoreSpicy {
    static int[] heap;
    static int size;
    public static void main(String[] args) {

    }

    public static int solution(int[] scoville, int k) {

        int answer = 0;
        size = 0;

        heap = new int[scoville.length + 1];

        for (int i = 1; i < heap.length; i++) {
            add(scoville[i - 1]);
        }

        while (peek() < k) {
            answer++;
            if (!mix()) {
                return -1;
            }
        }

        return answer;
    }

    static boolean mix() {
        if (size < 2) {
            return false;
        }
        int minNum1 = poll();
        int minNum2 = poll();

        int newNum = minNum1 + (minNum2 * 2);

        add(newNum);
        return true;
    }

    static void add(int num) {

        heap[++size] = num;

        int current = size;

        while (current > 1 && isPriority(current, current/2)) {

            swap(current, current / 2);
            current = current / 2;
        }
    }

    static int poll() {
        if(size<1) return -1;

        int minNum = heap[1];
        heap[1] = heap[size];
        heap[size] = 0;
        size--;

        int current = 1;

        while (current * 2 <= size) {
            int leftChildIndex = current *2;
            int rightChildIndex = current * 2 + 1;
            int smallerChildindex = leftChildIndex;

            if (current * 2 + 1 <= size && isPriority(rightChildIndex, leftChildIndex)) {
                smallerChildindex = rightChildIndex;
            }

            if (isPriority(current, smallerChildindex)) {
                break;
            }


            swap(current, smallerChildindex);
            current =  smallerChildindex;
        }
        return minNum;
    }

    static int peek(){
        return heap[1];
    }

    static void swap(int index1, int index2){
        int temp =  heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    // index1이 우선 순위인지 확인
    static boolean isPriority(int index1, int index2) {
        return heap[index1] <=  heap[index2];
    }
}
