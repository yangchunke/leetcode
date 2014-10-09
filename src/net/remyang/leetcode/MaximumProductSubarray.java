package net.remyang.leetcode;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		MaximumProductSubarray c = new MaximumProductSubarray();
		
		System.out.println(c.maxProduct(new int[]{0}));
		System.out.println(c.maxProduct(new int[]{-1}));
		System.out.println(c.maxProduct(new int[]{-1, 0, -2}));
		System.out.println(c.maxProduct(new int[]{-1, 1, -2}));
		System.out.println(c.maxProduct(new int[]{2,3,-2,4}));

	}

    public int maxProduct(int[] A) {
        int max = Integer.MIN_VALUE;
        
        int startIdx = -1;
        int firstMinusIdx = -1;
        int lastMinusIdx = -1;
        boolean plus = true;
        
        for(int i=0; i<A.length; i++){
            if (A[i]==0){
            	if (max<0){
                    max = 0;
                }
                if (startIdx!=-1){
                    int lmax = this.localMaximum(A, startIdx, i, firstMinusIdx, lastMinusIdx, plus);
                    if (lmax>max){
                        max = lmax;
                    }
                }
                startIdx = -1;
                firstMinusIdx = -1;
                lastMinusIdx = -1;
                plus = true;
            }
            else
            {
                if (startIdx==-1){
                    startIdx = i;
                }
                if (A[i]<0){
                    if (firstMinusIdx==-1){
                        firstMinusIdx = i;
                    }
                    lastMinusIdx = i;
                    plus = !plus;
                }
            }
        }
        
        if (startIdx!=-1){
            int lmax = this.localMaximum(A, startIdx, A.length, firstMinusIdx, lastMinusIdx, plus);
            if (lmax>max){
                max = lmax;
            }
        }

        return max;
    }
    
    private int localMaximum(int[] A, int startIdx, int endIdx, int firstMinusIdx, int lastMinusIdx, boolean plus){
    	int local = A[startIdx];
        if (plus){
            for(int j=startIdx+1; j<endIdx;j++){
                local*=A[j];
            }
            return local;
        }
        else 
        {
            for(int j=startIdx+1; j<lastMinusIdx; j++){
            	local *= A[j];
            }
            
            int secondHalfIdx = firstMinusIdx + 1;
            if (secondHalfIdx<endIdx)
            {
                int secondHalf = A[secondHalfIdx];
                for(int j=secondHalfIdx+1; j<endIdx; j++){
                    secondHalf *= A[j];
                }
                if (secondHalf>local){
                	local  = secondHalf;
                }
            }
        }
        return local;
    }	
}
