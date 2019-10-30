package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/20 on 19:39
 **/
public class S45_judgeIsContinuous {
    /**
     * judge whether 5 cards are orderly or not 
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length < 1){
            return false;
        }
        int length = numbers.length;
        //sort
        for (int i = 0; i <length-1 ; i++) {
            boolean flag = false;
            for (int j = length-1; j >i ; j--) {
                if(numbers[j] == numbers[j-1] && numbers[j] != 0){
                    return false;
                }else if(numbers[j] < numbers[j-1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
        for (int i = 0; i < length ; i++) {
            System.out.println("i"+numbers[i]);
        }
        //calculate the number of zero
        int numberOfZeros = 0;
        for (int i = 0; i < length && numbers[i] == 0 ; i++) {
            numberOfZeros ++ ;
        }
        int small = numberOfZeros;
        int big = small+1;
        int numberOfGap = 0;
        while (big < length){
            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return numberOfZeros >= numberOfGap;
    }

    public static void main(String[] args) {
        int[] array = {1,3,0,5,0};
        S45_judgeIsContinuous solution45 = new S45_judgeIsContinuous();
        System.out.println(solution45.isContinuous(array));
    }
}
