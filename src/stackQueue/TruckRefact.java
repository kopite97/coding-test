package stackQueue;

import java.util.*;

public class TruckRefact {
    public static void main(String[] args) {

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> bridge = new ArrayDeque<>();

        int second =0;
        int currentWeightOnBridge = 0;
        int index =0;

        while(index < truck_weights.length || !bridge.isEmpty()) {
            second++;

            // 1. 나갈 트럭이 있는지 확인 (현재 시간이 나갈 시간과 일치하다면 제거)
            if (!bridge.isEmpty() && bridge.peek().exitTime == second) {
                currentWeightOnBridge -= bridge.poll().weight;
            }

            // 2. 대기 중인 트럭이 다리에 올라올 수 있는지 확인
            if(index<truck_weights.length) {
                if (currentWeightOnBridge + truck_weights[index] <= weight) {
                    //트럭 진입
                    int tWeight = truck_weights[index++];
                    currentWeightOnBridge += tWeight;
                    bridge.offer(new Truck(tWeight, second + bridge_length));

                } else{

                    // 무게 제한으로 못 들어올 때 : 시간을 가장 빨리 나갈 트럭의 시간으로 점프
                    // (주의 : 바로 second를 바꾸면 다음 루프의 second++와 충돌하므로 -1을 해준다)
                    if(!bridge.isEmpty()) {
                        second = bridge.peek().exitTime -1;
                    }

                }
            }
        }

        return second;
    }

    static class Truck {
        int weight;
        int exitTime;

        Truck(int weight, int exitTime) {
            this.weight = weight;
            this.exitTime = exitTime;
        }
    }
}
