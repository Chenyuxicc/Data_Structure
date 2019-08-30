package com.chen.swordOffer;

import java.util.LinkedList;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/30 on 16:31
 **/
public class Solution63 {
    LinkedList<Integer> linkedList = new LinkedList<>();
    public void Insert(Integer num) {
        if(linkedList.isEmpty()){
            linkedList.add(num);
            return;
        }
        int size = linkedList.size();
        for (int i = 0; i < linkedList.size() ; i++) {
            if(num <= linkedList.get(0)){
                linkedList.add(0,num);
                break;
            }else if(num >= linkedList.get(linkedList.size()-1)){
                linkedList.add(size,num);
                break;
            }else if(num >= linkedList.get(i) && num <= linkedList.get(i+1)){
                linkedList.add(i+1,num);
                break;
            }
        }
    }
    public Double GetMedian() {
        int size = linkedList.size();

        if(size % 2 != 0){
            return  (double)linkedList.get(size/2);
        }else{
            return ((double)linkedList.get(size/2-1)+(double)linkedList.get(size/2))/2;
        }
    }
    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        solution63.Insert(3);
        solution63.Insert(1);
        solution63.Insert(2);
        solution63.Insert(8);
        solution63.Insert(7);
        solution63.Insert(9);
        solution63.Insert(-5);
        solution63.Insert(6);
        for (int i = 0; i <solution63.linkedList.size() ; i++) {
            System.out.println("i:"+solution63.linkedList.get(i));
        }
        System.out.println("------------");
        System.out.println(solution63.GetMedian());
    }
}
