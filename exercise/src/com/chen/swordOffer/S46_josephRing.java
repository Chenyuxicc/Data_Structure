package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/21 on 10:33
 **/
public class S46_josephRing {
    /**
     * calculate which one is the last person in Joseph ring
     */
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        if(n == 1){
            return 0;
        }else {
            return (LastRemaining_Solution(n-1,m)+m)%n;
        }
    }
    /**
     * circulation way
     *
     */
    public int LastRemaining_Solution1(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        int last = 0;
        for (int i = 2 ; i <= n ; i++) {
            last = (last+m)%i;
        }
        return last;
    }

    public static void main(String[] args) {
        S46_josephRing solution46 = new S46_josephRing();
        System.out.println(solution46.LastRemaining_Solution(5,3));
    }
}
