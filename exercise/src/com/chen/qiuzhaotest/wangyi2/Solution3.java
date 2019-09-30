package com.chen.qiuzhaotest.wangyi2;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/27 on 20:13
 **/
class block extends Object{
    int x;
    int y;
    boolean visited = false;
    public block(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void setVisited(){
        this.visited = true;
    }
    public boolean getVisited(){
        return this.visited;
    }
    @Override
    public int hashCode(){
        return x & y;
    }
    @Override
    public boolean equals(Object B){
        block b = (block)B;
        if(this.x == b.x && this.y == b.y){
            return true;
        }else {
            return false;
        }
    }
}
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            int temp = in.nextInt();
            block[] arr = new block[temp];
            for (int j = 0; j < temp; j++) {
                block b = new block(in.nextInt(),in.nextInt());
                arr[j] = b;
            }
            HashSet<block> set1 = new HashSet<>();
            for (int j = 0; j < temp; j++) {
                block t = arr[j];
                set1.add(t);
                for (int k = 0; k < temp; k++) {
                    if(k == j){
                        continue;
                    }
                    if(arr[k].y < arr[j].y){
                        int tx = arr[k].x > arr[j].x ? arr[j].x : arr[k].x;
                        block tb = new block(tx,arr[k].y);
                        set1.add(tb);
                    }
                }
            }
            result[i] = set1.size();
        }
        for (int i = 0; i < count; i++) {
            System.out.println(result[i]);
        }
    }
}
