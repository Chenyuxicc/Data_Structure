package com.chen.swordOffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/17 on 9:01
 * finished:2019/4/20 on 19:20
 **/
//输入一个字符串，输出字符串中的字符各种可能的排序
public class S26_allPermutation {
    public ArrayList<String> Permutation(String str) {
       int length=str.length();
       ArrayList<Character> origin=new ArrayList<>();
       if(length==0){
           return new ArrayList<>();
       }
       TreeSet<String> arrayLists=new TreeSet<>();
        for (int i = 0; i <length ; i++) {
            origin.add(str.charAt(i));
        }
        arrayLists=Permutation(arrayLists,origin,0);
        ArrayList<String> a=new ArrayList<>(arrayLists);
        return a;
    }
    public TreeSet<String> Permutation(TreeSet<String> arrayLists,ArrayList<Character> c,int begin){
        //是先把第一个和自己交换，再把后面序列的第一个也跟自己交换，交还到后面的序列只剩下一个元素才将其加入到arraylist中
        //接着再把第一个和下一个交换，此时序列已经改变，再交换后序序列的第一个和其自己，再一直交换到后序序列只剩一个元素，再将其加入arralist中
        if(begin==c.size()-1){
            StringBuffer temp=new StringBuffer();
            for (Character a:new ArrayList<>(c)) {
                temp.append(a);
            }
            arrayLists.add(temp.toString());
        }else{
            char ch=c.get(begin);
            for (int i = begin; i <c.size() ; i++) {
                char temp=c.get(i);
                c.set(i,ch);
                c.set(begin,temp);
                Permutation(arrayLists,c,begin+1);
                c.set(begin,ch);
                c.set(i,temp);

            }
        }
        return arrayLists;
    }

    public static void main(String[] args) {
        String str="aa";
        S26_allPermutation s=new S26_allPermutation();
        System.out.println(s.Permutation(str));
    }
}
