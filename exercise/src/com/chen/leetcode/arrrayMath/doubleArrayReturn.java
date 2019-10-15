package com.chen.leetcode.arrrayMath;

import java.util.ArrayList;

/**
 * @author chenyuxi
 * @since 19-9-5:下午9:38
 */
public class doubleArrayReturn {
    public static ArrayList<Integer> printMatrix(int [][] matrix){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)){
            return arrayList;
        }
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        /**
         * 起始位置是(0,0),(1,1)....每次都从起始位置开始回文打印
         * 循环的终止条件为 start * 2 >= rows && start * 2 >= cols
         */
        while (start * 2 < rows && start * 2 < cols){
            printMatrixInCycle(arrayList,matrix,start,rows,cols);
            start++;
        }
        return arrayList;
    }
    /**
     * 回文打印函数，传入参数为起始位置以及二维数组的行数和列数
     */
    private static void printMatrixInCycle(ArrayList<Integer> arr,int[][] matrix,int start,int rows,int cols){
        int endX = cols - start - 1;
        int endY = rows - start - 1;
        for (int i = start; i <= endX; i++) {
            arr.add(matrix[start][i]);
        }
        if(start < endY){
            for (int i = start + 1; i <= endY ; i++) {
                arr.add(matrix[i][endX]);
            }
        }
        if(start < endY && start < endX){
            for (int i = endX - 1; i >= start ; i--) {
                arr.add(matrix[endY][i]);
            }
        }
        if(start < endX && start < endY - 1){
            for (int i = endY - 1; i > start ; i--) {
                arr.add(matrix[i][start]);
            }
        }
    }
}
