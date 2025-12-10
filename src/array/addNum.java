package array;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86051?language=java
 */
public class addNum {
    public static void main(String[] args) {

    }

    public int solution(int[] numbers){
        int answer = 45;

        for(int i=0;i<numbers.length;i++){
            answer -=numbers[i];
        }
        return answer;
    }
}
