package com.chen.leetcode.matrix;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/31 on 15:22
 **/
public class S48_rotateMatrix {
    public void rotate(int[][] matrix) {
        if(matrix == null){
            return;
        }
        int n = matrix.length;
        if(n == 0){
            return;
        }
        /**
         * matrix[0][0] - matrix[0][2]
         * matrix[0][1] - matrix[1][2]
         * matrix[0][2] - matrix[2][2]
         *
         * matrix[1][0] - matrix[0][1]
         * matrix[1][1] - matrix[1][1]
         * matrix[1][2] - matrix[2][1]
         *
         * matrix[2][0] - matrix[0][0]
         * matrix[2][1] - matrix[1][0]
         * matrix[2][2] - matrix[2][0]
         *
         * matrix[0][0] - matrix[0][2] matrix[0][2] - matrix[2][2] matrix[2][2] - matrix[2][0] matrix[2][0] - matrix[0][0]
         * matrix[0][1] - matrix[1][2] matrix[1][2] - matrix[2][1] matrix[2][1] - matrix[1][0] matrix[1][0] - matrix[0][1]
         */
         int i = 0;
         while (i < n/2){
             for (int j = i; j < n-1-i; j++) {
                 int temp1 = matrix[i][j];
                 int temp2 = matrix[j][n- 1 - i];
                 int temp3 = matrix[n - 1 -i][n - 1 - j];
                 int temp4 = matrix[n-1-j][i];

                 matrix[j][n-1-i] = matrix[i][j];
                 matrix[n - 1 -i][n - 1 - j] = temp2;
                 matrix[n-1-j][i] = temp3;
                 matrix[i][j] = temp4;
             }
             i++;
         }
    }
}
