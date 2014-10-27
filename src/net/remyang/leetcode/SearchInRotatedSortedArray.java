package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		SearchInRotatedSortedArray c = new SearchInRotatedSortedArray();
		System.out.println(c.search(new int[] { 3, 1 }, 3));
	}

	public int search(int[] A, int target) {
		return rotatedSearch(A, 0, A.length, target);
	}

	private int rotatedSearch(int[] A, int start, int end, int target) {
		if (start >= end)
			return -1;

		int middle = start + (end - start) / 2;

		if (A[middle] == target) {
			return middle;
		} else if (A[middle] > target) {
			if (A[middle] < A[start]) {
				return rotatedSearch(A, start, middle, target);
			} else {
				int ret = binarySearch(A, start, middle, target);
				if (ret == -1) {
					ret = rotatedSearch(A, middle + 1, end, target);
				}
				return ret;
			}
		}
		if (A[middle] > A[end - 1]) {
			return rotatedSearch(A, middle + 1, end, target);
		}
		int ret = binarySearch(A, middle + 1, end, target);
		if (ret == -1) {
			ret = rotatedSearch(A, start, middle, target);
		}
		return ret;
	}

	private int binarySearch(int[] A, int start, int end, int target) {
		if (start >= end)
			return -1;
		int middle = start + (end - start) / 2;
		if (A[middle] == target) {
			return middle;
		} else if (A[middle] > target) {
			return binarySearch(A, start, middle, target);
		}
		return binarySearch(A, middle + 1, end, target);
	}
}
