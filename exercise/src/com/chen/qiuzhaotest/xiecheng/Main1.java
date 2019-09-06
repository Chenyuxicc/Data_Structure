package com.chen.qiuzhaotest.xiecheng;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/4 on 19:31
 **/
public class Main1 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        if(head.next == null || head == null){
            return head;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode p1 = bigHead;
        ListNode p2 = smallHead;
        ListNode p = head;
        bigHead.next = p;
        ListNode temp = null;
        while (p != null){
            temp = p.next;
            if(p.val < m){
                p1.next = p;
                p1 = p1.next;
                p1.next = null;
            }else {
                p2.next = p;
                p2 = p2.next;
                p2.next = null;
            }
            p = temp;
        }
        p2.next = bigHead.next;
        return smallHead.next;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
