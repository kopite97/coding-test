package array;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12949
 */

public class MatrixMultiplication {
    public static void main(String[] args) {

    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {

        int column1 = arr1.length;
        int row1 = arr1[0].length;
        int row2 = arr2[0].length;

        int[][] result = new int[column1][row2];

        /**
         * 행렬의 곱셈
         */
        for(int i=0;i<column1;i++){
            for(int j=0;j<row2;j++){
                for(int k=0;k<row1;k++){
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}
