package com.chen.test.cache;

import java.util.Hashtable;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:13
 */
public class lru {
    class DLinkedNode{
        DLinkedNode pre;
        DLinkedNode next;
        int key;
        int value;
    }
    private DLinkedNode head;
    private DLinkedNode tail;
    //插入的时候插在队头
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.next = head.next;

        head.next = node;
        node.next.pre = node;
    }
    //从链表中删除一个元素
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }
    //将一个元素移到队头,重要
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }
    //将队尾的元素出队，重要
    private DLinkedNode popTail(){
        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private Hashtable<Integer,DLinkedNode> cache = new Hashtable<>();
    private int capacity;
    private int size;

    //初始化capacity size head,tail
    public lru(int capacity){
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        //get逻辑：从cache中通过key获取node，如果获取成功则移动，并返回值
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    public void put(int key,int value){
        //放入元素逻辑：先判断cache里是否有key相同的node，没有就创建node插入，还需要判断删除最近最少使用的node
        //否则直接修改node的value为给定的value，并将Node移到开头
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key,newNode);
            addNode(newNode);

            ++size;
            if(size > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }

    }

}

