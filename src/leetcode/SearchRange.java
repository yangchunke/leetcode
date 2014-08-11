package leetcode;

public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] searchRange(int[] A, int target) {
        return searchRange(A, 0, A.length, target);
    }
    
    private int[] searchRange(int[] A, int start, int end, int target){
        int middle = binarySearch(A, start, end, target);
        
        if (middle==-1){
            return new int[]{-1,-1};
        }
        
        int[] range = new int[]{middle, middle};

        int[] left = searchRange(A, start, middle, target);
        int[] right = searchRange(A, middle+1, end, target);
        
        if (left[0]!=-1){
            range[0] = left[0];
        }
        if (right[1]!=-1){
            range[1] = right[1];
        }
        return range;
    }
    
    private int binarySearch(int[] A, int start, int end, int target){
        if (start==end) return -1;
        int middle = start + (end - start)/2;
        if (A[middle]==target) return middle;
        if (A[middle]>target) return binarySearch(A, start, middle, target);
        return binarySearch(A, middle+1, end, target);
    }

}
