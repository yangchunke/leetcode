package net.remyang.leetcode;

import java.util.Arrays;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		LongestConsecutiveSequence c = new LongestConsecutiveSequence();
		System.out.println(c.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
		System.out.println(c.longestConsecutive(new int[]{1, 0, 1, 2}));
	}

	public int longestConsecutive(int[] num) {
        if (num==null || num.length==0){
            return 0;
        }
        
        Arrays.sort(num);
        int maxLen=1, localLen=1;
        int prevVal = num[0];
        for(int i=1; i<num.length; i++){
        	if (num[i]==prevVal){
        		continue;
        	}
        	else if (num[i] == prevVal+1){
        		prevVal = num[i];
        		localLen++;
        	}
        	else
        	{
                if (localLen>maxLen){
                    maxLen = localLen;
                }
                prevVal  = num[i];
                localLen = 1;
            }
        }
        
        if (localLen>maxLen){
            maxLen = localLen;
        }
        
        return maxLen;
    }	
}
