package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/spiral-matrix-ii/
 *
 *         Given an integer n, generate a square matrix filled with elements
 *         from 1 to n2 in spiral order.
 * 
 *         For example, Given n = 3,
 * 
 *         You should return the following matrix: 
 *         [ [ 1, 2, 3 ], 
 *           [ 8, 9, 4 ], 
 *           [ 7, 6, 5 ] 
 *         ]
 */
public class SpiralMatrixII {

	public static void main(String[] args) {
		SpiralMatrixII c = new SpiralMatrixII();

		int[][] ret = c.generateMatrix(1);

		for (int y = 0; y < ret.length; y++) {
			for (int x = 0; x < ret[y].length; x++) {
				System.out.print(ret[y][x] + " ");
			}
			System.out.println("");
		}
	}

	public int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];

		int sy = 0, sx = 0;
		int ey = n, ex = n;
		int s = 1;

		while (sy < ey && sx < ex) {
			int x = sx;
			int y = sy;

			// right
			for (; x < ex; x++) {
				ret[y][x] = s++;
			}

			// down
			y++;
			x--;
			for (; y < ey; y++) {
				ret[y][x] = s++;
			}

			// left
			y--;
			x--;
			for (; x > sx; x--) {
				ret[y][x] = s++;
			}

			// up
			for (; y > sy; y--) {
				ret[y][x] = s++;
			}

			sy++;
			sx++;
			ey--;
			ex--;
		}

		return ret;
	}
}
