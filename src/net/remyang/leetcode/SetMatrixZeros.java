package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/set-matrix-zeroes/
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * click to show follow up.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 */
public class SetMatrixZeros {

	public void setZeroes(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;

		boolean firstRowIsZero = matrix[0][0] == 0;
		boolean firstColIsZero = matrix[0][0] == 0;

		if (!firstRowIsZero) {
			for (int x = 1; x < n; x++) {
				if (matrix[0][x] == 0) {
					firstRowIsZero = true;
					break;
				}
			}
		}

		if (!firstColIsZero) {
			for (int y = 1; y < m; y++) {
				if (matrix[y][0] == 0) {
					firstColIsZero = true;
					break;
				}
			}
		}

		// set matrix[0][1..n)
		for (int x = 1; x < n; x++) {
			if (matrix[0][x] != 0) {
				for (int y = 1; y < m; y++) {
					if (matrix[y][x] == 0) {
						matrix[0][x] = 0;
						matrix[y][0] = 0;
						break;
					}
				}
			}
		}

		// set matrix[1..m)[0]
		for (int y = 1; y < m; y++) {
			if (matrix[y][0] != 0) {
				for (int x = 1; x < n; x++) {
					if (matrix[y][x] == 0) {
						matrix[y][0] = 0;
						matrix[0][x] = 0;
						break;
					}
				}
			}
		}

		// set matrix[1..m)[x]=0 if matrix[0][x] = 0, where x is in [1,n)
		for (int x = 1; x < n; x++) {
			if (matrix[0][x] == 0) {
				for (int y = 1; y < m; y++) {
					matrix[y][x] = 0;
				}
			}
		}

		// set matrix[y][1..n)=0 if matrix[y][0] = 0, where y is in [1,m)
		for (int y = 1; y < m; y++) {
			if (matrix[y][0] == 0) {
				for (int x = 1; x < n; x++) {
					matrix[y][x] = 0;
				}
			}
		}

		if (firstRowIsZero) {
			for (int x = 0; x < n; x++) {
				matrix[0][x] = 0;
			}
		}

		if (firstColIsZero) {
			for (int y = 0; y < m; y++) {
				matrix[y][0] = 0;
			}
		}
	}
}
