package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/16 on 9:36
 * finished:11:16
 **/
//复制复杂链表
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
//边界条件
public class Solution24 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode p=pHead;
        if(p==null){
            return null;
        }
        RandomListNode head=new RandomListNode(p.label);
        RandomListNode q=head;
        p=p.next;
        while(p!=null){
            q.next=new RandomListNode(p.label);
            q=q.next;
            p=p.next;
        }
        p=pHead;
        q=head;
        while(p!=null){
            RandomListNode r=p.random;
            if(r==null){
                q.random=null;
            }
            else{
                q.random=findRandomNode(head,r.label);
            }
            p=p.next;
            q=q.next;
        }
        return head;

    }
    public RandomListNode findRandomNode(RandomListNode head,int label){
        RandomListNode p=head;
        while(p!=null){
            if(p.label==label){
                return p;
            }
            p=p.next;
        }
        return null;
    }
    //推荐做法，将克隆出的新链表的每一个节点都放在原来节点的后面
    public RandomListNode Clone1(RandomListNode pHead){
        RandomListNode p=pHead;
        if(p==null){
            return null;
        }
        RandomListNode q=p;
        RandomListNode head=p;
        RandomListNode k=q;
        //将每一个节点后面都放置一个跟他相同的复制节点p
        while(p!=null){
            q=new RandomListNode(p.label);
            q.next=p.next;
            p.next=q;
            p=q.next;
        }
        p=pHead;
        q=pHead.next;
        while(p!=null){
            q=p.next;
            if(p.random!=null){
                q.random=p.random.next;
            }else {
                q.random=null;
            }
            p=q.next;
        }
        p=pHead;
        q=pHead.next;
        head=q;
        while(q!=null){
            p.next=q.next;
            p=p.next;
            if(p!=null){
                q.next=p.next;
            }else{
                q.next=null;
            }
            q=q.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RandomListNode r=new RandomListNode(1);
        RandomListNode r1=new RandomListNode(2);
        RandomListNode r2=new RandomListNode(3);
        r.next=r1;
        r1.next=r2;
        r.random=r2;
        r1.random=r;
        r2.random=r1;
        Solution24 s=new Solution24();
        RandomListNode rhead=s.Clone1(r);
        RandomListNode p=rhead;
        RandomListNode q=rhead;
        while(p!=null){
            System.out.println("p:"+p.label);
            System.out.println("q:"+p.random.label);
            p=p.next;
        }
    }
}