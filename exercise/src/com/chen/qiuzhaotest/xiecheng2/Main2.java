package com.chen.qiuzhaotest.xiecheng2;

import java.util.*;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/14 on 11:05
 **/
public class Main2 {
    static int BestMatch(int[] LimitArray, int[][] DegMatrix) {
        return 1;

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _LimitArray_size = 0;
        int _DegMatrix_rows = 0;
        int _DegMatrix_cols = 0;
        _DegMatrix_rows = Integer.parseInt(in.nextLine().trim());
        _DegMatrix_cols = Integer.parseInt(in.nextLine().trim());
        _LimitArray_size = _DegMatrix_cols;

        int[] _LimitArray = new int[_LimitArray_size];
        int _LimitArray_item;
        for(int _LimitArray_i = 0; _LimitArray_i < _LimitArray_size; _LimitArray_i++) {
            _LimitArray_item = Integer.parseInt(in.nextLine().trim());
            _LimitArray[_LimitArray_i] = _LimitArray_item;
        }

        int[][] _DegMatrix = new int[_DegMatrix_rows][_DegMatrix_cols];
        for(int _DegMatrix_i=0; _DegMatrix_i<_DegMatrix_rows; _DegMatrix_i++) {
            for(int _DegMatrix_j=0; _DegMatrix_j<_DegMatrix_cols; _DegMatrix_j++) {
                _DegMatrix[_DegMatrix_i][_DegMatrix_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = BestMatch(_LimitArray, _DegMatrix);
        System.out.println(res);
    }
}
