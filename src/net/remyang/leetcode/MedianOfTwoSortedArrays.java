package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 *
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		MedianOfTwoSortedArrays c = new MedianOfTwoSortedArrays();
		System.out.println(c.findMedianSortedArrays(new int[] {},
				new int[] { 1 }));
		System.out.println(c.findMedianSortedArrays(new int[] { 1 },
				new int[] { 1 }));
		System.out.println(c.findMedianSortedArrays(new int[] { 1, 2 },
				new int[] { 1, 2 }));
		System.out.println(c.findMedianSortedArrays(new int[] { 1, 2 },
				new int[] { 1, 2, 3 }));
	}

	public double findMedianSortedArraysOk(int A[], int B[]) {

		int lengthOfA = A.length;
		int lengthOfB = B.length;

		int preMedianPosition = (lengthOfA + lengthOfB) / 2;

		int preMedianValue = 0;
		int indexOfA = 0;
		int indexOfB = 0;
		int indexOfMedian = 0;

		while (indexOfMedian < preMedianPosition) {
			if (indexOfA == lengthOfA) {
				// reaches to the end of A, will pick one from B
				preMedianValue = B[indexOfB++];
			} else if (indexOfB == lengthOfB) {
				// reaches to the end of B, will pick one from A
				preMedianValue = A[indexOfA++];
			} else if (A[indexOfA] < B[indexOfB]) {
				// pick the smaller one from A
				preMedianValue = A[indexOfA++];
			} else {
				// pick the smaller one from B
				// reaches to the end of B, will pick one from A
				preMedianValue = B[indexOfB++];
			}
			indexOfMedian++;
		}

		int medianValue = 0;
		if (indexOfA == lengthOfA) {
			// reaches to the end of A, will pick one from B
			medianValue = B[indexOfB];
		} else if (indexOfB == lengthOfB) {
			// reaches to the end of B, will pick one from A
			medianValue = A[indexOfA];
		} else if (A[indexOfA] < B[indexOfB]) {
			// pick the smaller one from A
			medianValue = A[indexOfA];
		} else {
			// pick the smaller one from B
			// reaches to the end of B, will pick one from A
			medianValue = B[indexOfB];
		}

		if ((preMedianPosition + preMedianPosition) < (lengthOfA + lengthOfB)) {
			// the total is an odd number, so return the median value.
			return medianValue;
		} else {
			// the total is an even number, return the average of the two
			// values.
			return (preMedianValue + medianValue) / 2.0;
		}
	}

	public double findMedianSortedArrays(int A[], int B[]) {

		int middle = (A.length + B.length) / 2 + 1;
		double median = findKth(A, B, 0, A.length, 0, B.length, middle);

		if ((A.length + B.length) % 2 == 0) {
			median += findKth(A, B, 0, A.length, 0, B.length, middle - 1);
			median /= 2;
		}

		return median;
	}

	private int findKth(int A[], int B[], int startA, int endA, int startB,
			int endB, int k) {
		if (startA >= endA)
			return B[startB + k - 1];
		if (startB >= endB)
			return A[startA + k - 1];
		if (k <= 1)
			return Math.min(A[startA], B[startB]);

		int middleA = startA + (endA - startA) / 2;
		int middleB = startB + (endB - startB) / 2;

		int numA = middleA - startA;
		int numB = middleB - startB;

		if (A[middleA] >= B[middleB]) {
			if ((numA + numB >= k - 1)) {
				// A[middleA] is at least larger than k of the elements in the
				// two arrays.
				// A[middleA..endA) can be discarded.
				return findKth(A, B, startA, middleA, startB, endB, k);
			} else {
				// B[middleB] is at most the (k-1)th element in the two arrays.
				// discard B[startB..middleB]
				return findKth(A, B, startA, endA, middleB + 1, endB, k - numB
						- 1);
			}
		} else {
			if ((numA + numB >= k - 1)) {
				// B[middleB] is at least larger than k of the elements in the
				// two arrays.
				// B[middleB..endB) can be discarded.
				return findKth(A, B, startA, endA, startB, middleB, k);
			} else {
				// A[middleA] is at most the (k-1)th element in the two arrays.
				// discard A[startA..middleA]
				return findKth(A, B, middleA + 1, endA, startB, endB, k - numA
						- 1);
			}
		}
	}
}
