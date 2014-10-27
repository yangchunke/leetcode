package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/search-insert-position/
 * 
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. 
 * [1,3,5,6], 5 -> 2 
 * [1,3,5,6], 2 -> 1 
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 *
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		SearchInsertPosition c = new SearchInsertPosition();
		System.out.println(c.searchInsert(new int[] {}, 0));
		System.out.println(c.searchInsert(new int[] { 1 }, 0));
		System.out.println(c.searchInsert(new int[] { 1 }, 2));
		System.out.println(c.searchInsert(new int[] { 1, 3, 5 }, 0));
		System.out.println(c.searchInsert(new int[] { 1, 3, 5 }, 1));
		System.out.println(c.searchInsert(new int[] { 1, 3, 5 }, 2));
		System.out.println(c.searchInsert(new int[] { 1, 3, 5 }, 3));
		System.out.println(c.searchInsert(new int[] { 1, 3, 5 }, 4));
		System.out.println(c.searchInsert(new int[] { 1, 3, 5 }, 5));
		System.out.println(c.searchInsert(new int[] { 1, 3, 5 }, 6));
	}

	public int searchInsert(int[] A, int target) {
		return binarySearchInsert(A, 0, A.length, target);
	}

	private int binarySearchInsert(int[] A, int start, int end, int target) {

		if (start >= end)
			return start;

		int middle = start + (end - start) / 2;
		if (A[middle] == target) {
			return middle;
		} else if (A[middle] > target) {
			return binarySearchInsert(A, start, middle, target);
		} else {
			return binarySearchInsert(A, middle + 1, end, target);
		}
	}
}
