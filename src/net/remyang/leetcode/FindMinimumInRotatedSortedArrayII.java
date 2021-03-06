package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII {

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArrayII c = new FindMinimumInRotatedSortedArrayII();
		System.out.println(c.findMin(new int[] { 0, 0, 1 }));
		System.out.println(c.findMin(new int[] { 0, 1, 0 }));
		System.out.println(c.findMin(new int[] { 0, 1, 0, 0 }));
		System.out.println(c.findMin(new int[] { 1, 1, 1, 0, 1 }));
		System.out.println(c.findMin(new int[] { 2, 0, 1, 2, 2, 2, 2, 2 }));
		System.out.println(c.findMin(new int[] { 2, 2, 2, 2, 2, 0, 1, 2 }));
		System.out.println(c.findMin(new int[] { 0, 1 }));
		System.out.println(c.findMin(new int[] { 1, 0 }));
		System.out.println(c.findMin(new int[] { 2, 0, 1 }));
		System.out.println(c.findMin(new int[] { 3, 4, 0, 1 }));
		System.out.println(c.findMin(new int[] { 3, 4, 0, 1, 2 }));
		System.out.println(c.findMin(new int[] { 3, 0, 1, 2 }));
	}

	public int findMin(int[] num) {
		int start = 0;
		int end = num.length;

		while (start < end) {
			int middle = start + (end - start) / 2;
			if (num[start] <= num[middle] && num[middle] <= num[end - 1]) {
				while (start < end - 1 && num[start] >= num[end - 1]) {
					start++;
				}
				break;
			} else if (num[start] <= num[middle]) {
				start = middle;
			} else {
				start++;
				end = middle + 1;
			}
		}

		return num[start];
	}
}
