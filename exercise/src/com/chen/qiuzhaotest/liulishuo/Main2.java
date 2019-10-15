package com.chen.qiuzhaotest.liulishuo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/11 on 13:25
 **/
public class Main2 {
    private static int M;
    private static int N;
    private static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] t = in.nextLine().trim().split(" ");
        //列数
        N = t.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (in.hasNextInt()){
            arrayList.add(in.nextInt());
        }
        M = arrayList.size() / N + 1;
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            if(i == 0){
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.valueOf(t[j]);
                }
            }else {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = arrayList.get(count % N);
                    count++;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 2){

                }
            }
        }
    }
    public void dfs(int[][] arr,int x,int y){
        if(x < M && x >= 0 && y < N && y >= 0 && arr[x][y] == 3){
            return;
        }else if(x < M && x >= 0 && y < N && y >= 0 && arr[x][y] == 0){
            count++;
        }else {
            return;
        }
        dfs(arr,x+1,y);
        dfs(arr,x-1,y);
        dfs(arr,x,y+1);
        dfs(arr,x,y-1);
    }
}
