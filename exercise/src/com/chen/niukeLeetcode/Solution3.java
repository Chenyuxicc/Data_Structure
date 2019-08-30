package com.chen.niukeLeetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/9 on 18:20
 **/
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
/**
 * find the maximum number of points whose x is same
 */
public class Solution3 {
    public int maxPoints(Point[] points) {
        if(points.length == 0){
            return 0;
        }
        if(points.length == 1){
            return 1;
        }
        int length = points.length;
        int result = 0;
        for (int i = 0; i < length ; i++) {
            int dup = 0;
            int ver = 0;
            int curMax = 1;
            Map<Double,Integer> map = new HashMap<>();
            for (int j = 0; j < length ; j++) {
                if(i != j){
                    double x1 = points[i].x - points[j].x;
                    double y1 = points[i].y - points[j].y;
                    if(x1 == 0 && y1 == 0){
                        dup++;
                    }else if(x1 == 0){
                        if(ver == 0){
                            ver = 2;
                        }else {
                            ver ++;
                        }
                        curMax = curMax > ver ? curMax : ver;
                    }else {
                        double k = y1/x1;
                        if(!map.containsKey(k)){
                            map.put(k,2);
                        }else {
                            int num = map.get(k);
                            map.replace(k,++num);
                        }
                        curMax = curMax > map.get(k) ? curMax : map.get(k);
                    }
                }
                result = result > (curMax+dup) ? result : (curMax+dup);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Point p = new Point(1,1);
        Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);
        Point p3 = new Point(2,2);
        Point[] points = {p,p1,p2,p3};
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.maxPoints(points));
    }
}


