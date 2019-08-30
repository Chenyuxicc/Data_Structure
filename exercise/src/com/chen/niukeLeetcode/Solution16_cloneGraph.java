package com.chen.niukeLeetcode;
import java.util.*;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/20 on 16:51
 **/
class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }

    @Override
    public int hashCode() {
        return label;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof UndirectedGraphNode){
            return ((UndirectedGraphNode) obj).label == label;
        }
        return false;
    }
}
/**
 * 图的遍历
 * 先克隆出一个标签一样的，再把其邻接点都克隆出来，加入到克隆出来的这个节点的邻接点数组中，一个接点就克隆完成了和其边以及其邻接点就克隆出来了
 * 再克隆出邻接点的边以及其邻接点，如果使用递归，就只用克隆其邻接点即可，如果使用循环，需要使用一个栈或者队列来保存新克隆出来的邻接点
 * 因为它们的边和邻接点可能还没有被克隆出来，因此需要保存下来继续访问，另外需要一个map来保存已经生成过的邻接点，防止重复生成邻接点导致克隆失败
 */
public class Solution16_cloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        Stack<UndirectedGraphNode> stack = new Stack<>();
        if(node == null){
            return null;
        }
        UndirectedGraphNode firstNode = new UndirectedGraphNode(node.label);
        map.put(node,firstNode);
        stack.push(node);
        while (!stack.isEmpty()){
            UndirectedGraphNode root = stack.pop();
            ArrayList<UndirectedGraphNode> neighborNodes = new ArrayList<>();
            for (UndirectedGraphNode neighbor : root.neighbors) {
                if(map.containsKey(neighbor)){
                    neighborNodes.add(map.get(neighbor));
                }else {
                    stack.push(neighbor);
                    UndirectedGraphNode cloneNeighbor = new UndirectedGraphNode(neighbor.label);
                    neighborNodes.add(cloneNeighbor);
                    map.put(neighbor,cloneNeighbor);
                }
            }
            map.get(root).neighbors = neighborNodes;
        }
        return firstNode;
    }
    HashMap<Integer , UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node){
        return clone(node);
    }
    public UndirectedGraphNode clone(UndirectedGraphNode node){
        if(node == null){
            return null;
        }
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        ArrayList<UndirectedGraphNode> arrayList = new ArrayList<>();
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(cloneNode.label,cloneNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            arrayList.add(clone(neighbor));
        }
        cloneNode.neighbors = arrayList;
        return cloneNode;
    }
}
