package com.chen.qiuzhaotest.yuanfudao;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/16 on 9:27
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int M = Integer.valueOf(s[0]);
        int N = Integer.valueOf(s[1]);
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int[] result = printCircle(arr,M,N);
        for (int i = 0; i < result.length; i++) {
            if(i == result.length - 1){
                System.out.print(result[i]);
            }else {
                System.out.print(result[i] + " ");
            }
        }

    }
    public static int[] printCircle(int[][] arr,int M,int N){
        int startX = 0;
        int startY = 0;
        int endX = N - 1;
        int endY = M - 1;
        int[] result = new int[M*N];
        int index = 0;
        while (startX <= endX && startY <= endY){
            for (int i = startY; i <= endY; i++) {
                result[index] = arr[i][startX];
                index ++;
            }
            if(startX < endX){
                for (int i = startX + 1; i <= endX ; i++) {
                    result[index] = arr[endY][i];
                    index++;
                }
            }
            if(startX < endX && startY < endY){
                for (int i = endY - 1; i >= startY ; i--) {
                    result[index] = arr[i][endX];
                    index++;
                }
            }
            if(startY < endY && startX < endX - 1){
                for (int i = endX - 1; i > startX ; i--) {
                    result[index] = arr[startY][i];
                    index++;
                }
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return result;
    }

}
