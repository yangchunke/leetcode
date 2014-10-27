package net.remyang.leetcode;

public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int singleNumber(int[] A) {
		int result = 0;
		for (int i = 0; i < Integer.SIZE; i++) {
			int key = 0;
			for (int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) != 0) {
					key++;
				}
			}
			result |= ((key % 3) << i);
		}
		return result;
	}
}
