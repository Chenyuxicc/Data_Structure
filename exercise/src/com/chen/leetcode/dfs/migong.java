package com.chen.leetcode.dfs;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author chenyuxi
 * @since 19-9-16:下午3:03
 */
public class migong {
    /**
     * 迷宫问题：https://www.nowcoder.com/practice/cf24906056f4488c9ddb132f317e03bc?tpId=37&&tqId=21266&rp=1&ru=/activity/oj&qru=/ta/huawei/question-ranking
     * 使用两个栈来记录当前路径以及最佳路径，找到出口时判断当前路径的大小是否小于最佳路径的大小
     * 栈里存放的是每个点的路径
     */
    //行和列
    private static int N;
    private static int M;
//    //存放迷宫
//    private static ;
    //记录当前路径和最佳路径
    private static Stack<int[]> tempPath = new Stack<>();
    private static Stack<int[]> bestPath = new Stack<>();

    private static void mazeTrack(int i , int j,int[][] maze){
        maze[i][j] = 1;
        int[] cur = {i , j};
        tempPath.push(cur);
        if(i == N - 1 && j == M - 1){
            if(bestPath.isEmpty() || tempPath.size() < bestPath.size()) {
                bestPath = tempPath;
            }
        }
        if(i - 1 >= 0 && maze[i - 1][j] == 0){
            mazeTrack(i - 1 , j,maze);
        }
        if(i + 1 < N && maze[i + 1][j] == 0){
            mazeTrack(i + 1 , j,maze);
        }
        if(j - 1 >= 0 && maze[i][j - 1] == 0){
            mazeTrack(i , j - 1,maze);
        }
        if(j + 1 < M && maze[i][j + 1] == 0){
            mazeTrack(i , j + 1,maze);
        }
        maze[i][j] = 0;
        tempPath.pop();
    }
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        N = scanner.nextInt();
//        M = scanner.nextInt();
        N = 5;
        M = 5;
        int[][] maze = {{0 ,1 ,0, 0, 0},
                {0,1, 0, 1, 0},
                {0,0, 0, 0, 0},
                {0,1, 1, 1, 0},
                {0,0, 0, 1, 0}};
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                maze[i][j] = scanner.nextInt();
//            }
//        }
        mazeTrack(0 , 0,maze);
        System.out.println(tempPath.size());
        while (!bestPath.isEmpty()){
            int[] cur = bestPath.pop();
            System.out.println("(" + cur[0] + "," + cur[1] + ")");
        }
    }
}
