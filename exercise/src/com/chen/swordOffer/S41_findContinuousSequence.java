package com.chen.swordOffer;

import java.util.ArrayList;
/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/19 on 21:34
 **/
public class S41_findContinuousSequence {
    /**
     * to calculate unsigned integer ArrayList which the sum of they elements equal input sum
     * @param sum the num input
     * @return ArrayList<ArrayList<Integer>> the result
     *
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(sum<=2){
            return arrayLists;
        }
        for (int i = 2; i <= Math.sqrt(2*sum) ; i++) {
            //算常数项
            int constantTerm = i*(i-1)/2 ;
            //算中间值
            int temp = sum - constantTerm ;
            if(temp>0&&(temp)%i == 0){
                ArrayList<Integer> arrayList = new ArrayList<>();
                int n = temp/i;
                for (int j = 0; j < i ; j++) {
                    arrayList.add(n+j);
                }
                arrayLists.add(arrayList);
            }
        }
        return arrayLists;
    }
    /**
     * use two pointers
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence1(int sum){
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(sum<=2){
            return arrayLists;
        }
        int left = 1;
        int right = 2;
        while (right>left){
            System.out.println("left:"+left);
            System.out.println("right:"+right);
            System.out.println("-----------------");
            int result = (left+right)*(right-left+1)/2;
            if(result == sum){
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = left; i <=right ; i++) {
                    arrayList.add(i);
                }
                left++;
                arrayLists.add(arrayList);
            }else if(result<sum){
                right++;
            }else {
                left++;
            }
        }
        return arrayLists;

    }
    public static void main(String[] args) {
        S41_findContinuousSequence solution41 = new S41_findContinuousSequence();
        System.out.println(solution41.FindContinuousSequence1(100));
    }
}
