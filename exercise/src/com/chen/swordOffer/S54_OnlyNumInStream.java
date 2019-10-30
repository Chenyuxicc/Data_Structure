package com.chen.swordOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/27 on 19:49
 **/
public class S54_OnlyNumInStream {
    private int[] numberOfChar = new int[256];
    private HashMap<Character,Integer> hashMap = new LinkedHashMap<>(256);
    private StringBuffer stringBuffer = new StringBuffer();
    ArrayList<Character> arrayList = new ArrayList<>(256);
    /**
     * Insert one char from stringstream
     */
    public void Insert(char ch)
    {
      stringBuffer.append(ch);
      numberOfChar[ch]++;
      if(hashMap.containsKey(ch)){
          hashMap.replace(ch,hashMap.get(ch)+1);
      }else {
          hashMap.put(ch,1);
      }
      arrayList.add(ch);
    }
    /**
     * return the first appearence once char in current stringStream
     */
    public char FirstAppearingOnce()
    {
//        char[] chars = stringBuffer.toString().toCharArray();
//        for (char c:chars) {
//            if(numberOfChar[c] == 1){
//                return c;
//            }
//        }
        for (char c: arrayList) {
            if(hashMap.get(c) == 1){
                return c;
            }
        }
        return '#';
    }
}
