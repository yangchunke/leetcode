package net.remyang.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int threeSumClosest(int[] num, int target) {
        
        Arrays.sort(num);
        
        int minSum = Integer.MAX_VALUE;
        int minDelta = Integer.MAX_VALUE;
        
        for(int i=0; i<num.length-2; i++){
            int j = i+1;
            int k = num.length - 1;
            while(j<k){
                
                int sum = num[i]+num[j]+num[k];

                int delta = sum - target;
                if (delta==0){
                    return sum;
                }
                
                if (delta<0){
                    j++;
                    delta = -delta;
                }
                else
                {
                    k--;
                }
                
                if (delta<minDelta){
                    minDelta = delta;
                    minSum = sum;
                }
            }
        }
        
        return minSum;
    }
}
