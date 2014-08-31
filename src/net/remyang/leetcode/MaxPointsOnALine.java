/**
 * 
 */
package net.remyang.leetcode;

/**
 * @author chunkeya
 * 
 */

import java.util.*;

class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
}

public class MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        if (points==null || points.length==0)
            return 0;
            
        int maxPoints = 1;
        
        for(int i=0; i<points.length; i++){
            
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int dup = 1;
            Point p1 = points[i];
            
            for(int j=i+1; j<points.length;j++){
                Point p2 = points[j];
                if (p1.x==p2.x&&p1.y==p2.y){
                    dup++;
                }
                else
                {
                    double key = getKey(p1,p2);
                    if (map.containsKey(key))
                    {
                        map.put(key, map.get(key)+1);
                    }
                    else{
                        map.put(key,1);
                    }
                }
            }
            
            if (dup>maxPoints){
                maxPoints = dup;
            }
            
            for(int m : map.values()){
                if (m+dup>maxPoints){
                    maxPoints = m+dup;
                }
            }
        }
        
        return maxPoints;
    }
    
    private double getKey(Point p1, Point p2){
        if (p1.x == p2.x){
            return Double.MAX_VALUE;
        }
        else if (p1.y == p2.y){
            return 0.0;
        }
        return ((double)(p2.y - p1.y))/((double)(p2.x - p1.x));
    }	
}
