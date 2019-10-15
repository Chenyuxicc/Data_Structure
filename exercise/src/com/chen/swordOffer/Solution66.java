package com.chen.swordOffer;

import java.util.ArrayList;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/1 on 21:21
 **/
public class Solution66 {
    public int movingCount(int threshold, int rows, int cols){
        if(rows<0 || cols<0 || threshold < 0){
            return 0;
        }
        boolean[] visited = new boolean[rows*cols];

        return countMoving(threshold,rows,cols,0,0,visited);

    }
    private int countMoving(int thread,int rows,int cols,int row,int col,boolean[] visited){
        int count = 0;
        if(row >= 0 && row < rows && col >= 0 && col < cols && checkCount(thread,row,col) && !visited[row*cols+col]){
            System.out.println("i:"+row+","+"j:"+col);

            visited[row*cols+col] = true;
            count = 1 + countMoving(thread,rows,cols,row+1,col,visited)
                    +countMoving(thread,rows,cols,row-1,col,visited)
                    +countMoving(thread,rows,cols,row,col+1,visited)
                    +countMoving(thread,rows,cols,row,col-1,visited);
        }
        return count;
    }
    private boolean checkCount(int threshold,int rows,int cols){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        while(rows>0){
            int digit = rows % 10;
            rows = rows / 10;
            arrayList.add(digit);
        }
        while (cols>0){
            int digitc = cols % 10;
            cols = cols / 10;
            arrayList.add(digitc);
        }
        for (int i = 0; i <arrayList.size() ; i++) {
            sum += arrayList.get(i);
            if(sum > threshold){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        System.out.println(solution66.movingCount(5,3,3));
    }
}
