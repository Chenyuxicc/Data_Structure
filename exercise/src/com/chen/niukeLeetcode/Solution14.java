package com.chen.niukeLeetcode;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/16 on 12:51
 **/
public class Solution14 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0 || cost.length == 0){
            return -1;
        }
        int restOfGas = 0;
        for (int i = 0; i < gas.length ; i++) {
            restOfGas += gas[i];
            int j = i;
            while (restOfGas >= cost[j]){
                restOfGas -= cost[j];
//                System.out.println("cost:"+cost[j]);
//                System.out.println("restof:"+restOfGas);
//                System.out.println("j:"+j);
//
//                System.out.println("--------");
                if(restOfGas < 0){
//                    System.out.println("出去了");
                    break;
                }
                j++;
                if(j >= gas.length){
                    j = j-gas.length;
                }
                restOfGas += gas[j];
            }
            restOfGas = 0;
            if(i-j == 1 || (i == 0 && j == gas.length-1)){
                return i;
            }
        }
        return -1;
    }
    public int canCompleteCircuit1(int[] gas, int[] cost){
        if(gas.length == 0 || cost.length == 0){
            return -1;
        }
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while (end < start){
            if(sum>0){
                sum += gas[end] - cost[end];
                end++;
            }else {
                start--;
                sum += gas[start] - cost[start];
            }
        }
        return sum >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {3,8,7,2,1,2};
        int[] cost = {2,9,6,8,7,1};
        Solution14 solution14 = new Solution14();
        int i = solution14.canCompleteCircuit(gas,cost);
        System.out.println("i:"+i);
    }
}
