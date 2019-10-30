package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/22 on 10:49
 **/
public class S50_duplicateNum {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length == 0 || length == 1){
            return false;
        }
        int[] assistArray = new int[length];
        for (int i = 0; i < length ; i++) {
            assistArray[i] = 0;
        }
        for (int i = 0; i < length ; i++) {
            assistArray[numbers[i]]++;
            if(assistArray[numbers[i]] == 2){
                duplication[0] = numbers[i];
                System.out.println(duplication[0]);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] numbers = {2,3,1,0,6,5,4};
        int[] duplication = {0};
        S50_duplicateNum solution50 = new S50_duplicateNum();
        System.out.println(solution50.duplicate(numbers,numbers.length,duplication));
    }
}
