package com.chen.leetcode.huisu;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2020/1/13 on 16:18
 **/
/**
 * 传播约束条件
 * 回溯
 */
public class S37_solveSudoku {

    int n = 3;
    int N = n*n;

    //横坐标表示行/列/小格子编号，纵坐标表示已经填过的数字，为约束条件
    int[][] rows = new int[N][N + 1];
    int[][] cols = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];

    char[][] board = new char[N][N];
    boolean solved = false;
    //修改约束数组，放置数字
    public void placeNum(int d,int row,int col){
        //表示每个小格的编号
        int indx = (row / n) * n + col / n;

        rows[row][d]++;
        cols[col][d]++;
        boxes[indx][d]++;
        board[row][col] =  (char) (d + '0');
    }
    public void placeNextNum(int row,int col){
        if(row == N - 1 && col == N - 1 ){
            solved = true;
        }else {
            //转行
            if(col == N - 1){
                backTrack(row + 1 , 0);
            }else {
                backTrack(row , col + 1);
            }
        }
    }

    public void removeNum(int d,int row,int col){
        int indx = (row / n ) * n + col / n;

        rows[row][d] -- ;
        cols[col][d] -- ;
        boxes[indx][d] -- ;
        board[row][col] = '.';
    }

    public boolean couldPlace(int d,int row, int  col){
        int indx = ( row / n ) * n + col / n;
//        System.out.println("row:"+row);
//        System.out.println("col:"+col);
//        System.out.println("indx:" + indx);
        return (rows[row][d] + cols[col][d] + boxes[indx][d]) == 0;
    }
    public void backTrack(int row,int col){
//        System.out.println("row:"+row);
//        System.out.println("col:"+col);
        if(board[row][col] == '.'){
            for (int i = 1; i < N + 1; i++) {
                if(couldPlace(i,row,col)){
                    placeNum(i,row,col);
                    placeNextNum(row , col);

                    if(!solved){
                        removeNum(i,row,col);
                    }
                }
            }
        }else {
            placeNextNum(row,col);
        }

    }


    /**
     * board中空格使用'.'表示
     */
    public void solveSudoku(char[][] board){
        this.board = board;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] != '.'){
                    //因为传入的num要当作数组下标，所以需要先转为数字
                    int num = Character.getNumericValue(board[i][j]);
                    placeNum(num, i,j);
                }
            }
        }
        backTrack(0 , 0);
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        S37_solveSudoku s = new S37_solveSudoku();
        s.solveSudoku(board);
    }
        
}
