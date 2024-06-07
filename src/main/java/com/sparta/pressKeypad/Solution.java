package com.sparta.pressKeypad;

class Solution {

    public String solution(int[] numbers, String hand) {
        String answer = "";

        for (int index : numbers) {
            System.out.print(index + " ");
        }
        System.out.println();

        int[][] num = new int[4][3];

        int count = 1;
        char[][] nums = new char[4][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = (char) (count + '0');
                count++;
            }
        }

        nums[3][0] = '*';
        nums[3][1] = '0';
        nums[3][2] = '#';

        int[] lHand = {3, 0};
        int[] rHand = {3, 2};

        for (int index : numbers) {
            if (index == 1 || index == 4 || index == 7) {
                lHand[0] = index / 3;
                lHand[1] = 0;

                answer += "L";

            } else if (index == 3 || index == 6 || index == 9) {
                rHand[0] = index / 3-1;
                rHand[1] = 2;

                answer += "R";

            } else { // 2 5 8 0
                int i = index / 3;
                if (index == 0) {
                    i = 3;
                }

                int lSqr= Math.abs(i-lHand[0])+ Math.abs(1-lHand[1]);
                int rSqr = Math.abs(i-rHand[0])+ Math.abs(1-rHand[1]);

                if(lSqr ==0 )
                {
                    answer +="L";
                    continue;
                }
                if(rSqr ==0 ){
                    answer +="R";
                    continue;
                }

                // 왼쪽에서의 거리가 더 가깝다면
                if (lSqr < rSqr) {
                    answer += "L";
                    lHand[0] = i;
                    lHand[1] = 1;
                } else if (lSqr > rSqr) {
                    rHand[0] = i;
                    rHand[1] = 1;
                    answer += "R";
                } else if((int)Math.sqrt(lSqr) == (int)Math.sqrt(rSqr) ){
                    String dir = hand.substring(0, 1).toUpperCase();
                    answer += dir;
                    if (dir.equals("R")) {
                        rHand[0] = i;
                        rHand[1] = 1;
                    } else if (dir.equals("L")) {
                        lHand[0] = i;
                        lHand[1] = 1;
                    }
                }

            }
        }

        System.out.println("answer = " + answer);

        return answer;
    }
}