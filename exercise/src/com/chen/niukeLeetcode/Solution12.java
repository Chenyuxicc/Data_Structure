package com.chen.niukeLeetcode;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/15 on 16:54
 **/
public class Solution12 {
    public int singleNumber(int[] A) {
        quickSort(A, 0, A.length - 1);
        for (int i = 0; i < A.length; ) {
            if (i + 1 < A.length && i + 2 < A.length) {
                if (A[i] == A[i + 1] && A[i] == A[i + 2]) {
                    i += 3;
                } else {
                    return A[i];
                }
            } else {
                return A[i];
            }
        }
        return A[0];
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end || start < 0 || end > array.length - 1) {
            return;
        }
        int temp = array[start];
        int i = 0;
        int j = 0;
        for (i = start, j = end; i < j; ) {
            while (array[j] >= temp && i < j) {
                j--;
            }
            array[i] = array[j];
            while (array[i] <= temp && i < j) {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = temp;
        quickSort(array, start, i - 1);
        quickSort(array, i + 1, end);
    }

    public static void main(String[] args) {
        int[] array = {3, 0, 3, 2, 3, 2, 0, 2, 0, -1, 6, 4, 6, 4, 6, 4};
        Solution12 solution12 = new Solution12();
        solution12.quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println("i:" + array[i]);
        }
        int a = solution12.singleNumber(array);
        System.out.println(a);
    }
}
