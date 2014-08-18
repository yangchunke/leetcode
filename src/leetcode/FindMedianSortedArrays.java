/**
 * 
 */
package leetcode;

/**
 * http://leetcode.com/onlinejudge#question_4
 * 
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * 
 * The overall run time complexity should be O(log (m+n)).
 *
 */
public class FindMedianSortedArrays {
	
	public static void main(String[] args){
		FindMedianSortedArrays c = new FindMedianSortedArrays();
		System.out.println(c.findMedianSortedArrays(new int[]{1}, new int[] {1}));
	}
    public double xxfindMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lengthOfA = A.length;
        int lengthOfB = B.length;
        
        int preMedianPosition = (lengthOfA + lengthOfB)/2;
        
        int preMedianValue = 0;
        int indexOfA = 0;
        int indexOfB = 0;
        int indexOfMedian = 0;
        
        while(indexOfMedian<preMedianPosition){
            if (indexOfA==lengthOfA){
                // reaches to the end of A, will pick one from B
                preMedianValue = B[indexOfB++];
            }
            else if (indexOfB==lengthOfB){
                // reaches to the end of B, will pick one from A
                preMedianValue = A[indexOfA++];
            }
            else if (A[indexOfA]<B[indexOfB]){
                // pick the smaller one from A
                preMedianValue = A[indexOfA++];                
            }
            else{
                // pick the smaller one from B
                // reaches to the end of B, will pick one from A
                preMedianValue = B[indexOfB++];                
            }
            indexOfMedian++;
        }
        
        int medianValue = 0;
        if (indexOfA==lengthOfA){
            // reaches to the end of A, will pick one from B
            medianValue = B[indexOfB];
        }
        else if (indexOfB==lengthOfB){
            // reaches to the end of B, will pick one from A
            medianValue = A[indexOfA];
        }
        else if (A[indexOfA]<B[indexOfB]){
            // pick the smaller one from A
            medianValue = A[indexOfA];                
        }
        else{
            // pick the smaller one from B
            // reaches to the end of B, will pick one from A
            medianValue = B[indexOfB];                
        }        
        
        if ((preMedianPosition+preMedianPosition)<(lengthOfA+lengthOfB)){
            // the total is an odd number, so return the median value.
            return medianValue;
        }
        else
        {
            // the total is an even number, return the average of the two values.
            return (preMedianValue + medianValue)/2.0;
        }
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        
        int middle = (A.length+B.length)/2+1;
        double middleVal = findKth(A,B,0,A.length,0,B.length,middle);
        
        if ((A.length+B.length)%2==0)    
        {
            middleVal += findKth(A,B,0,A.length,0,B.length,middle-1);
            middleVal /= 2.0;
        }
        
        return middleVal;
    }
    
    private int findKth(int A[], int B[], int aStart, int aEnd, int bStart, int bEnd, int k)
    {
        if (aStart>=aEnd){
            return B[bStart+k-1];
        }
        
        if (bStart>=bEnd){
            return A[aStart+k-1];
        }
        
        if(k<=1){
            return A[aStart]>B[bStart]?B[bStart]:A[aStart];
        }
        
        int mA = aStart + (aEnd-aStart)/2;
        int mB = bStart + (bEnd-bStart)/2;
        
        if (A[mA]>B[mB]){
            if (k<(mA+mB)){
                return findKth(A,B,aStart,mA,bStart,bEnd,k);
            }else{
                return findKth(A,B,aStart,aEnd,mB,bEnd,k-mB+bStart);
            }
        }
        else
        {
            if (k<(mA+mB)){
                return findKth(A,B,aStart,aEnd,bStart,mB,k);
            }else{
                return findKth(A,B,mA,aEnd,bStart,bEnd,k-mA+aStart);
            }
        }
    }
}
