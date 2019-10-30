package com.chen.swordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/20 on 19:20
 * finished 2019/4/20 19:54
 **/
//找出数组中出现次数超过数组长度一半的数字
public class S27_moreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
       int length=array.length;
       if(length==0){
           return 0;
       }
       HashMap<Integer,Integer> hashMap=new HashMap<>();
       hashMap.put(array[0],1);
       for(int i=1;i<length;i++){
           if(hashMap.containsKey(array[i])){
               int n=hashMap.get(array[i]);
               n=n+1;
               hashMap.replace(array[i],n);
           }
           else{
               hashMap.put(array[i],1);
           }
       }
        for (Map.Entry<Integer,Integer> entry:
             hashMap.entrySet()) {
             if(entry.getValue()>length/2){
                 return entry.getKey();
             }
        }
        return 0;
    }
}
