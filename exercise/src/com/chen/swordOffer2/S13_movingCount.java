package com.chen.swordOffer2;

/**
 * @author ChenYuXi
        * @version 1.0
        * @since 2019/10/16 on 16:40
        **/
public class S13_movingCount {
    public int movingCount(int threshold, int rows, int cols){
        boolean[] visited = new boolean[rows * cols];
        return getCount(visited,threshold,rows,cols,0,0);
    }
    public int getCount(boolean[] visited,int threshold,int rows,int cols,int row,int col){
        int count = 0;
        if(row >= 0 && row < rows && col >= 0 && col < cols && !visited[cols * row + col]&&getNum(row,col) < threshold){
            visited[cols * row + col ] = true;
            count = 1 + getCount(visited,threshold,rows,cols,row + 1, col) +
                    getCount(visited,threshold,rows,cols,row - 1, col) +
                    getCount(visited,threshold,rows,cols,row, col + 1) +
                    getCount(visited,threshold,rows,cols,row,col-1);
        }
        return count;
    }
    public int getNum(int row,int col){
        int num = 0;
        while (row != 0){
            int c = row % 10;
            num += c;
            row /= 10;
        }
        while (col != 0){
            int t = col % 10;
            num += t;
            col /= 10;
        }
        return num;
    }
}
