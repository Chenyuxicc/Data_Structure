package com.chen.qiuzhaotest.mihayou;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/10 on 19:10
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] t = in.nextLine().split(" ");
        int rows = Integer.valueOf(t[0]);
        int cols = Integer.valueOf(t[1]);
        char[][] array = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String s = in.nextLine();
            for (int j = 0; j < cols; j++) {
                array[i][j] = s.charAt(j);
            }
        }
        String[] t2 = in.nextLine().split(" ");
        int x1 = Integer.valueOf(t2[0]);
        int y1 = Integer.valueOf(t2[1]);
        int x2 = Integer.valueOf(t2[2]);
        int y2 = Integer.valueOf(t2[3]);
        char temp = array[x1][y1];
        array[x1][y1] = array[x2][y2];
        array[x2][y2] = temp;
        int count = numOfDelete(array,rows,cols);
        System.out.println(count);
    }
    public static int numOfDelete(char[][] chars , int rows , int cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

            }
        }
        return 0;
    }
}
