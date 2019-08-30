package com.chen.niukeLeetcode;
import java.util.*;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/14 on 17:17
 **/
public class Solution10 {
    public ArrayList<String> wordBreak2(String s, Set<String> dict) {
        return DFS(s,dict,new HashMap<String,ArrayList<String>>());
    }
    private ArrayList<String> DFS(String s, Set<String> dict, HashMap<String,ArrayList<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        ArrayList<String> strings = new ArrayList<>();
        if(s.length() == 0){
            strings.add("");
        }
        for (String subStr : dict){
            System.out.println("subStr:"+subStr);
            if(s.startsWith(subStr)){
                for (String str : DFS(s.substring(subStr.length()),dict,map)){
                    strings.add(subStr+(str.equals("")? "" : " ")+str);
                }
            }
        }
        map.put(s,strings);
        Collections.reverse(strings);
        return strings;
    }
    public boolean wordBreak1(String s, Set<String> dict) {
        int length = s.length();
        boolean[] booleans = new boolean[length+1];
        booleans[0] = true;
        for (int i = 1; i <= length ; i++) {
            for (int j = 0; j < i ; j++) {
                if(booleans[j] && dict.contains(s.substring(j ,i))){
                    booleans[i] = true;
                    break;
                }
            }
        }
        return booleans[length];
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        Set<String> dict = new HashSet<>();
        dict.add("aaaa");
        dict.add("aaa");
        Solution10 solution10 = new Solution10();
        ArrayList<String> arrayList = solution10.wordBreak2(s,dict);
        for (String string:
             arrayList) {
            System.out.println(string);
        }
    }
}
