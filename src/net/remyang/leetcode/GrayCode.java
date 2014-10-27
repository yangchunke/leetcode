package net.remyang.leetcode;

import java.util.*;

/**
 * @author chunkeya
 * 
 *         The gray code is a binary numeral system where two successive values
 *         differ in only one bit.
 * 
 *         Given a non-negative integer n representing the total number of bits
 *         in the code, print the sequence of gray code. A gray code sequence
 *         must begin with 0.
 * 
 *         For example, given n = 2, return [0,1,3,2]. Its gray code sequence
 *         is:
 * 
 *         00 - 0 01 - 1 11 - 3 10 - 2 Note: For a given n, a gray code sequence
 *         is not uniquely defined.
 * 
 *         For example, [0,2,3,1] is also a valid gray code sequence according
 *         to the above definition.
 * 
 *         For now, the judge is able to judge based on one instance of gray
 *         code sequence. Sorry about that.
 */
public class GrayCode {

	public static void main(String[] args) {
		GrayCode c = new GrayCode();
		List<Integer> ret = c.grayCode(3);
		for (int i : ret) {
			System.out.println(i);
		}
	}

	public List<Integer> grayCode(int n) {
		List<Integer> ret = new ArrayList<Integer>();

		int val = 0;
		int endBits = n;
		while (endBits > 0) {
			int mask = 1;
			for (int i = 0; i < endBits; i++) {
				ret.add(val);
				val ^= mask;
				mask <<= 1;
			}
			endBits--;
		}
		ret.add(val);

		return ret;
	}
}
