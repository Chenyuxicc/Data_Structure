package com.chen.swordOffer2;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/16 on 10:26
 **/
public class S12_matrixPath {
    public boolean haspath(char[] matrix,int rows,int cols,char[] str){
        //用来防止再次判断该点
        boolean[] visited = new boolean[matrix.length];
        //访问str指针
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(checkPath(str,matrix,rows,cols,i,j,visited,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkPath(char[] str,char[] matrix,int rows,int cols,int row,int col,boolean[] visited,int index){
        if(index == str.length){
            return true;
        }
        boolean haspath = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && str[index] == matrix[row * cols + col]){
            visited[row * cols + col] = true;
            index++;
            haspath = checkPath(str,matrix,rows,cols,row + 1 , col , visited , index) ||
                    checkPath(str,matrix,rows,cols,row - 1 ,col,visited,index) ||
                    checkPath(str,matrix,rows,cols,row,col+1,visited,index) ||
                    checkPath(str,matrix,rows,cols,row,col - 1,visited,index);
            if(!haspath){
                visited[row * cols +col] = false;
                index--;
            }
        }
        return haspath;
    }
}
