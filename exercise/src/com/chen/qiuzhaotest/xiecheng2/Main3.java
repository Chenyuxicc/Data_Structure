package com.chen.qiuzhaotest.xiecheng2;


import java.util.Scanner;

public class Main3 {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] array = new int[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                array[i][j] = in.nextInt();
            }
        }
        boolean[][] visited = new boolean[rows][cols];
        check(0,0,rows-1,cols-1,array);
        System.out.println(count);
    }

    public static void check(int i, int j, int rows, int cols, int[][] array) {
        if(i==rows&&j==cols) {
            count++;
            return;
        }else if(i>rows || i < 0){
            return;
        }else if (j>cols || j < 0) {
            return;
        }
        if(array[i][j]==1) {
            return;
        }
        check(i+1, j, rows, cols, array);
        check(i, j+1, rows, cols, array);
    }

}
