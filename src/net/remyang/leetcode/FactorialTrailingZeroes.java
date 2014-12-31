package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		FactorialTrailingZeroes c = new FactorialTrailingZeroes();
		for (int i = 0; i < 50; i++) {
			System.out.println(i + ": " + c.trailingZeroes(i));
		}
	}

	public int trailingZeroes(int n) {
		return n == 0 ? 0 : (n / 5 + trailingZeroes(n / 5));
	}
}
