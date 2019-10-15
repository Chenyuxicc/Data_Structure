package com.chen.leetcode.stack;

import java.util.Objects;
import java.util.Stack;

/**
 * @author chenyuxi
 * @since 19-9-6:下午1:36
 */
public class SharedStack<E> {
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
    public boolean push1(E data){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.peek();
        if(top1 + 1 == top2){
            return false;
        }else {
            arr[++top1] = data;
            return true;
        }
    }
    public boolean push2(E data){
        if(top2 - 1 == top1){
            return false;
        }else {
            arr[--top1] = data;
            return true;
        }
    }
    @SuppressWarnings("unchecked")
    public E pop1(){
        if(top1 <= -1){
            //抛出异常
            return null;
        }else {
            return (E)this.arr[top1--];
        }
    }
    @SuppressWarnings("unchecked")
    public E pop2(){
        if(top2 >= arr.length){
            throw new MyException();
        }else {
            return (E)this.arr[top2];
        }

    }
    @SuppressWarnings("unchecked")
    public E peek1(){
        if(top1 == top2 || top1 <= -1){
            throw new MyException();
        }else {
            return (E)this.arr[top1];
        }
    }
    @SuppressWarnings("unchecked")
    public E peek2(){
        if(top2 >= arr.length || top2 == top1){
            throw new MyException();
        }else {
            return (E)this.arr[top2];
        }
    }


}
