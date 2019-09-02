package com.chen.qiuzhaotest.dangdang;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/2 on 19:20
 **/
public class Main1 {
    public static int numberOfBlock(int[][] map,int rows,int cols){
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(isBlock(map,visited,i,j,rows,cols)){
                    count++;
                }
            }
        }
        return count;
    }
    private static boolean isBlock(int[][] map,boolean[][] visited,int row,int col,int rows,int cols){
        if(row < 0 || row >= rows || col < 0 || col >= cols){
            return false;
        }
        if(map[row][col] == 1 && !visited[row][col]){
            visited[row][col] = true;
            isBlock(map,visited,row+1,col,rows,cols);
            isBlock(map,visited,row,col+1,rows,cols);
            isBlock(map,visited,row - 1,col,rows,cols);
            isBlock(map,visited,row,col-1,rows,cols);
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numRow = in.nextInt();
        int[][] numArrs = new int[numRow][];
        int numCols = in.nextInt();
        for (int i = 0; i < numRow; i++) {
            numArrs[i] = new int[numCols];
            for (int j = 0; j < numCols; j++) {
                numArrs[i][j] = in.nextInt();
            }
        }
        System.out.println(numberOfBlock(numArrs,numRow,numCols));
    }
}
