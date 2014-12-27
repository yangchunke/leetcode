package net.remyang.leetcode;

import java.util.HashMap;

/**
 * https://oj.leetcode.com/problems/longest-consecutive-sequence/
 *
 *
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		LongestConsecutiveSequence c = new LongestConsecutiveSequence();
		System.out.println(c.longestConsecutive(new int[] { 100, 4, 200, 1, 3,
				2 }));
		System.out.println(c.longestConsecutive(new int[] { 1, 0, 1, 2 }));
		System.out
				.println(c.longestConsecutive(new int[] { 1, 2, 5, 4, 3, 0 }));
	}

	public int longestConsecutive(int[] num) {
		int maxLength = 0;

		// number to length of consecutive sequence
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int n : num) {
			if (!map.containsKey(n)) {

				// get left and right boundaries
				int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
				int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;

				// set length for the current number
				int nowLength = left + right + 1;
				map.put(n, nowLength);

				// update left and right boundaries
				map.put(n - left, nowLength);
				map.put(n + right, nowLength);

				// update maximum length
				maxLength = Math.max(nowLength, maxLength);
			}
		}
		return maxLength;
	}
}
