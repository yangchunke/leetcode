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
    public double findMedianSortedArrays(int A[], int B[]) {
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
}
