package com.chen.swordOffer2;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/17 on 10:36
 **/
public class S14_cutRope {
    int maxLength = 0;
    /**
     * 初值和子问题的最优解不同，好像不能使用递归来做
     */
    public int cutRope(int target) {
        if(target < 2){
            return 0;
        }else if(target == 2){
            return 1;
        }else if(target == 3){
            return 2;
        }
        for (int i = 4; i < target; i++) {
            int temp = cutRope(i) * cutRope(target - i);
            if(temp > maxLength){
                maxLength = temp;
            }
        }
        return maxLength;
    }
    public int cutRope1(int length){
        if(length < 2){
            return 0;
        }else if(length == 2){
            return 1;
        }else if(length == 3){
            return 2;
        }
        //位置为0的不存,存放的是子问题的最优解
        int[] result = new int[length+1];
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        //不能从3开始，3的最优解是一刀都不切
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                int temp =  result[j] * result[i-j];
                if(max < temp){
                    max = temp;
                }
            }
            result[i] = max;
        }
        return result[length];
    }
    public int cutRope2(int length){
        if(length < 2){
            return 0;
        }else if(length == 2){
            return 1;
        }else if(length == 3){
            return 2;
        }
        int timesOfThree = length / 3;
        if(length - timesOfThree * 3 == 1){
            timesOfThree--;
        }
        int timeOfTwo = (length - timesOfThree * 3) / 2;
        return (int)(Math.pow(3,timesOfThree) * Math.pow(2,timeOfTwo));
    }
}
