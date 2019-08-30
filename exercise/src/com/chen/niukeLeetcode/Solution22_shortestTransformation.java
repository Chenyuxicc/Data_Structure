package com.chen.niukeLeetcode;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/7/2 on 15:41
 **/
public class Solution22_shortestTransformation {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int res = 1;
        HashSet<String> startSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        startSet.add(start);
        endSet.add(end);
        while (!startSet.isEmpty() && !endSet.isEmpty()){
            if(startSet.size() > endSet.size()){
                HashSet<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }
            HashSet<String> temp = new HashSet<>();
            for (String str : startSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i <chars.length ; i++) {
                    char old = chars[i];
                    for (char j = 'a'; j <= 'z' ; j++) {
                        chars[i] = j;
                        str = String.valueOf(chars);
                        if(endSet.contains(str)){
                            return res+1;
                        }
                        if(dict.contains(str)){
                            temp.add(str);
                            dict.remove(str);
                        }
                    }
                    chars[i] = old;
                }
            }
            startSet = temp;
            res++;
        }
        return 0;
    }
    class Pair{
        String string;
        ArrayList<String> path;
        HashSet<String> set;
        Pair(String s , ArrayList<String> arrayList , HashSet<String> set){
            this.string = s;
            this.path = arrayList;
            this.set = set;
        }
    }
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        path.add(start);
        hashSet.add(start);
        Queue<Pair> queue = new LinkedList<>();
        Pair node = new Pair(start,path,hashSet);
        queue.add(node);
        int minLength = -1;
        while (!queue.isEmpty()){
            Pair curNode = queue.poll();
            String str = curNode.string;
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (char j = 'a'; j < 'z' ; j++) {
                    chars[i] = j;
                    String newWord = String.valueOf(chars);
                    if(newWord.equals(end)){
                        path = node.path;
                        path.add(newWord);
                        int pathLength  = path.size();
                        if(minLength == -1){
                            minLength = pathLength;
                        }
                        if(pathLength > minLength){
                            return result;
                        }
                        result.add(path);
                    }else if(dict.contains(newWord) && !hashSet.contains(newWord)){
                        //直接添加就会改变当前节点的path,如果该节点是两条路径的公共节点，这样就会发生错误
                        //必须要新创建
                        path = new ArrayList<>(node.path);
                        hashSet = new HashSet<>(node.set);
                        path.add(newWord);
                        hashSet.add(newWord);
                        Pair newNode = new Pair(newWord,path,hashSet);
                        queue.add(newNode);
                    }
                }
            }
        }
        return result;
    }
}
