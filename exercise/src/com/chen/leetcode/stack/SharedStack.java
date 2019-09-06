package com.chen.leetcode.stack;

import java.util.Objects;
import java.util.Stack;

/**
 * @author chenyuxi
 * @since 19-9-6:下午1:36
 */
public class SharedStack<T> {
    private int top1;
    private int top2;
    private int length;
    private Object[] arr;
    public SharedStack(int length){
        this.length = length;
        arr = new Object[length];
        top1 = -1;
        top2 = this.length;
    }
    public boolean push1(T data){
        if(top1 + 1 == top2){
            return false;
        }else {
            arr[++top1] = data;
            return true;
        }
    }
    public boolean push2(T data){
        if(top2 - 1 == top1){
            return false;
        }else {
            arr[--top1] = data;
            return true;
        }
    }
    public T pop1(){
        if(top1 <= -1){
            //抛出异常
            return null;
        }else {
            return (T)this.arr[top1--];
        }
    }
    public T pop2(){
        if(top2 >= arr.length){
            throw new MyException();
        }else {
            return (T)this.arr[top2];
        }

    }
    public T peek1(){
        if(top1 == top2 || top1 <= -1){
            throw new MyException();
        }else {
            return (T)this.arr[top1];
        }
    }
    public T peek2(){
        if(top2 >= arr.length || top2 == top1){
            throw new MyException();
        }else {
            return (T)this.arr[top2];
        }
    }


}
