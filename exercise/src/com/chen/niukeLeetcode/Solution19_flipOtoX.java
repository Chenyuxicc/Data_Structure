package com.chen.niukeLeetcode;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/29 on 20:53
 **/
public class Solution19_flipOtoX {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row ; i++) {
            if (board[i][0] == 'O') {
                check(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                check(board, i, col - 1);
            }
        }
        for (int i = 0; i < col ; i++) {
            if(board[0][i] == 'O'){
                check(board,0,i);
            }
            if(board[row-1][i] == 'O'){
                check(board,row-1,i);
            }
        }
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'C'){
                    board[i][j] = 'O';
                }
            }
        }

    }
    public void check(char[][] board,int i,int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        if(board[i][j] == 'O'){
            board[i][j] = 'C';
        }
        if(j < board[0].length - 2 && board[i][j+1] == 'O'){
            check(board,i,j+1);
        }
        if(j > 1 && board[i][j-1] == 'O'){
            check(board,i,j-1);
        }
        if(i < board.length - 2 && board[i+1][j] == 'O'){
            check(board,i+1,j);
        }
        if(i > 1 && board[i-1][j] =='O'){
            check(board,i-1,j);
        }
    }
}
