package net.remyang.leetcode;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {		
		FindMinimumInRotatedSortedArray c = new FindMinimumInRotatedSortedArray();
		System.out.println(c.findMin(new int[]{1}));
		System.out.println(c.findMin(new int[]{0,1}));
		System.out.println(c.findMin(new int[]{1,0}));
		System.out.println(c.findMin(new int[]{2,0,1}));
		System.out.println(c.findMin(new int[]{3,4,0,1}));
		System.out.println(c.findMin(new int[]{3,4,0,1,2}));
		System.out.println(c.findMin(new int[]{3,0,1,2}));
	}

    public int findMin(int[] num) {
        int start = 0;
        int end = num.length;
        
        while(start < end){
            int middle = start + (end-start)/2;
            if (num[start]<=num[middle] && num[middle]<=num[end-1]){
                break;
            }
            else if (num[start]<=num[middle]){
                start = middle;
            }
            else{
            	start++;
                end = middle+1;
            }
        }
        
        return num[start];
    }	
}
