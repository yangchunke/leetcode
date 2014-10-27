package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/single-number-ii/
 *
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 */
public class SingleNumberII {

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
