package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/27 on 16:53
 **/
public class S53_isNumber {
    /**
     * to judge a char array is a number or not
     */
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0) {
            return false;
        }
        int indexOfe = findChar(str,'e');
        System.out.println("indexofe:"+indexOfe);
        int indexOfE = findChar(str,'E');
        System.out.println("indexofE:"+indexOfE);
        if(indexOfE != -1 && indexOfe != -1){
            return false;
        }else if(indexOfE != -1){
            return isANumber(str,0,indexOfE-1)&&isAInt(str,indexOfE+1,str.length-1);
        }else if (indexOfe != -1){
            return isANumber(str,0,indexOfe-1)&&isAInt(str,indexOfe+1,str.length-1);
        }
        return isANumber(str,0,str.length-1);
    }
    private int findChar(char[] str,char c){
        if(str == null || str.length == 0){return -1;}
        for (int i = 0; i < str.length ; i++) {
            if(str[i] == c){
                return i;
            }
        }
        return -1;
    }
    private boolean isANumber(char[] str,int start,int end){
        if(start < 0 || end >= str.length || start > end){
            return false;
        }
        boolean dotFlag = false;
        for (int i = start; i <end ; i++) {
            if(i == start && str[start] == '+' || str[start] == '-'){
                continue;
            }
            if(dotFlag && str[i] == '.'){
                return false;
            }
            if(str[i] == '.'){
                dotFlag = true;
                continue;
            }
            if(str[i] < '0' || str[i] > '9'){
                return false;
            }
          }
        return true;
    }

    private boolean isAInt(char[] str,int start,int end){
        if(start < 0 || end >= str.length || start > end){
            return false;
        }
        for (int i = start; i <= end; i++) {
                if(i == start && str[start] == '+' || str[start] == '-'){
                    continue;
                }
                if(str[i] < '0' || str[i] > '9'){
                    return false;
                }
        }
        return true;
    }
    /**
     * others answer:only traverse once can get the judgement
     *
     */
    public boolean isNumeric1(char[] str){
        if(str == null || str.length == 0){
            return false;
        }
        boolean sign = false;
        boolean decimalFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < str.length ; i++) {
            if(str[i] == 'e' || str[i] == 'E'){
                if(eFlag || i == str.length-1){
                    return false;
                }
                eFlag = true;
            }else if(str[i] == '+' || str[i] == '-'){
                if(eFlag && str[i-1] != 'E' && str[i-1] != 'e'){
                    return false;
                }
                if(!eFlag && i>0 && str[i-1] != 'E' && str[i-1] != 'e'){
                    return false;
                }
                sign = true;
            }else if(str[i] == '.'){
                if(eFlag || decimalFlag){
                    return false;
                }
                decimalFlag = true;
            }else if(str[i] < '0' || str[i] > '9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] str = {'1','2','3','.','4','5','e','+','6'};
        char[] str1 = {'+','-','1'};
        char[] str2 = {'1','2','e'};
        S53_isNumber solution53 = new S53_isNumber();
        System.out.println(solution53.isNumeric1(str));
    }
}
