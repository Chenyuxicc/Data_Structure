package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/7 on 19:51
 **/
public class Solution35 {
    public static void main(String[] args) {
        Solution35 solution35=new Solution35();
//        String s="whu.edu.cn";
//        String[] list=s.split("\\.");
//        for (String str:list
//             ) {
//            System.out.println("值为:"+str);
//        }
        int t=solution35.returnTest();


    }
    public int addSchool(Integer schoolId){
        int i=schoolId;
        System.out.println(i);
        return i;
    }
    public int returnTest(){
        System.out.println("return test start");
        int num=10;
        addSchool(num);
        System.out.println("return test end");
        return num;
    }
}
