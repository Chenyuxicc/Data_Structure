package com.chen.leetcode.matrix;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/20 on 11:29
 * 题目：有效的数独
 * 描述：判断一个数独是否有效，规则：9*9一行不能有重复,一列不能有重复，3*3小方格内不能有重复
 **/
public class S36_validSudoku {
    /**
     * 思路1:暴力：先判断每一行是否有重复的，再判断每一列是否有重复，再判断3*3方格内是否有重复
     * 思路2：优化，一次遍历同时判断一行一列以及一个宫格的元素是否有重复的
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            //判断行列宫格是否有重复数字的val，每行都需要三个
            int rowVal = 0 , colVal = 0 , matrixVal = 0;
            for (int j = 0; j < 9; j++) {
                //每行的值其中数字0的ascii值是48，而'.'的ascii值为46
                int row = board[i][j] - 48;
                int col = board[j][i] - 48;
                //每个宫格里的值从一行映射到矩阵的所有点坐标，第i行对应第i个宫格
                int matrixI = board[3*(i/3) + j / 3][3 *(i % 3) + j % 3] - 48;
                if(row > 0){
                    rowVal = isVisted(rowVal,row);
                }
                if(col > 0){
                    colVal = isVisted(colVal,col);
                }
                if(matrixI > 0){
                    matrixVal = isVisted(matrixVal,matrixI);
                }
                if(rowVal == -1 || colVal == -1 || matrixVal == -1){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 判断一个数是否被访问过
     */
    public int isVisted(int val,int n){
        return ((val >> n) & 1) == 1 ? -1 : (1 << n) | (val);
    }

    public static void main(String[] args) {
        char[][] board = {{'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        S36_validSudoku s = new S36_validSudoku();
        System.out.println(s.isValidSudoku(board));
        //System.out.println((320 >> 8)&1);
    }
}
