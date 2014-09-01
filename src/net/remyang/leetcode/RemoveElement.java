package net.remyang.leetcode;

public class RemoveElement {

	public static void main(String[] args) {
		RemoveElement c = new RemoveElement();
		
		System.out.println(c.removeElement(new int[]{1}, 2));
		System.out.println(c.removeElement(new int[]{1}, 1));
		System.out.println(c.removeElement(new int[]{1}, 0));
		System.out.println(c.removeElement(new int[]{1,2}, 1));
		System.out.println(c.removeElement(new int[]{1,2}, 2));
		System.out.println(c.removeElement(new int[]{1,2}, 3));
	}

	public int removeElement(int[] A, int elem) {
        int start = 0;
        int end = A.length;

        while(start<end){
            
            while(start<end && A[start]!=elem){
                start++;
            }
            if(start>=end){
                break;
            }
            while(end>start && A[end-1]==elem){
                end--;
            }
            if(end<=start){
                break;
            }            
            int t = A[start];
            A[start]=A[end-1];
            A[end-1]=t;
            
            start++;
            end--;
        }
        
        return start;
    }	
}
