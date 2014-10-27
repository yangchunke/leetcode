package net.remyang.leetcode;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/3sum-closest/
 *
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

	public int threeSumClosest(int[] num, int target) {

		Arrays.sort(num);

		int minSum = Integer.MAX_VALUE;
		int minDelta = Integer.MAX_VALUE;

		for (int i = 0; i < num.length - 2; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {

				int sum = num[i] + num[j] + num[k];

				int delta = sum - target;
				if (delta == 0) {
					return sum;
				}

				if (delta < 0) {
					j++;
					delta = -delta;
				} else {
					k--;
				}

				if (delta < minDelta) {
					minDelta = delta;
					minSum = sum;
				}
			}
		}

		return minSum;
	}
}
