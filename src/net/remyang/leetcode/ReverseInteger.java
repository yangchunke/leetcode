package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/reverse-integer/
 *
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 */
public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger c = new ReverseInteger();
		for (int i = -60000; i <= 60000; i += 1024) {
			System.out.println(i + ": " + c.reverse(i));
		}
		for (long i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i += 536870912) {
			System.out.println(i + ": " + c.reverse((int) i));
		}
	}

	public int reverse(int x) {
		long ret = 0;
		long xx = x > 0 ? x : -x;

		while (xx > 0) {
			long d = xx % 10;
			ret = ret * 10 + d;
			xx /= 10;
		}

		if (x < 0 && (ret - 1) > Integer.MAX_VALUE) {
			return 0;
		}

		if (x > 0 && ret > Integer.MAX_VALUE) {
			return 0;
		}

		return (int) (x > 0 ? ret : -ret);
	}
}
