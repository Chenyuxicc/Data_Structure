package com.chen.leetcode.linkedlist;

/**
 * @author chenyuxi
 * @since 19-9-5:上午10:48
 */

public class LinkedQueue<T> {
    /**
     * 需要考虑capacity，以及队中实际元素的大小
     * 在入队和出队时要考虑队为空以及队大小为1的情况
     */
    private int capacity;
    private ListNode front;
    private ListNode rear;
    /**
     * 队列中元素个数
     */
    private int count = 0;
    public LinkedQueue(int capacity){
        this.capacity = capacity;
        front = null;
        rear = null;
    }
    public boolean enQueue(T data){
        ListNode node = new ListNode(data);
        if(size() >= capacity){
            return false;
        }else {
            if(isEmpty()){
                front = node;
                front.next = null;
                rear = node;
                rear.pre = null;
                count++;
                return true;
            }
            if(size() == 1){
                rear = node;
                front.next = rear;
                rear.pre = front;
                count++;
                return true;
            }
            rear.next = node;
            node.pre = rear;
            rear = node;
            count++;
            return true;
        }
    }
    public T deQueue(){
        if(isEmpty()){
            return null;
        }else {
            ListNode temp = null;
            if(size() == 1){
                temp = front;
                front = null;
                rear = null;
                count--;
                return temp.data;
            }
            if(size() == 2){
                temp = front;
                front = rear;
                front.next = null;
                rear.pre = null;
                count--;
                return temp.data;
            }
            temp = front;
            front = front.next;
            count-- ;
            return temp.data;
        }
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count == 0;
    }
    class ListNode{
        T data;
        ListNode pre;
        ListNode next;
        public ListNode(T val){
            this.data = val;
        }
    }
}
