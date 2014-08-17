package leetcode;

public class TrappingRainWater {

	public static void main(String[] args) {
		TrappingRainWater c = new TrappingRainWater();
		System.out.println(c.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(c.trap(new int[]{2,0,2}));
	}

	public int trap(int[] A) {
        int water = 0;
        
        // from left to right
        int leftBar = -1;
        int rightBar = 0;
        for(;rightBar<A.length-1;rightBar++){
        	if (leftBar>-1 && A[rightBar]>=A[leftBar]){
                water += accumulate(A, leftBar, rightBar, 1);
                leftBar = -1;
            }
        	if (leftBar==-1 && A[rightBar]>A[rightBar+1]){
                leftBar = rightBar;
            }
        }
    	if (leftBar>-1 && A[rightBar]>=A[leftBar]){
            water += accumulate(A, leftBar, rightBar, 1);
            leftBar = -1;
        }
        
        // from right to left
        rightBar = A.length;
        leftBar = A.length-1;
        for(;leftBar>0;leftBar--){
            if (rightBar<A.length && A[leftBar]>A[rightBar]){
                water += accumulate(A, rightBar, leftBar, -1);
                rightBar = A.length;
            }
            if (rightBar==A.length && A[leftBar]>A[leftBar-1]){
                rightBar = leftBar;
            }
        }
        if (rightBar<A.length && A[leftBar]>A[rightBar]){
            water += accumulate(A, rightBar, leftBar, -1);
            rightBar = A.length;
        }
        
        return water;
    }
    
    private int accumulate(int[] A, int start, int end, int step){
        int highBar = A[start];
        int water = 0;
        while(start!=end){
            if (A[start]<highBar){
                water += (highBar - A[start]);
            }
            start += step;
        }
        return water;
    }

}
