package net.remyang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/multiply-strings/
 *
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {

	public static void main(String[] args) {
		MultiplyStrings ins = new MultiplyStrings();
		System.out.println(ins.multiply("699", "0"));
	}

	public String multiply(String num1, String num2) {
		String ret = new String("0");
		Map<Integer, String> cache = new HashMap<Integer, String>();

		int zeros = 0;
		for (int i = num1.length() - 1; i >= 0; i--, zeros++) {
			int cc = num1.charAt(i) - '0';
			if (cc != 0) {
				String s = _multi(num2, cc, zeros, cache);
				ret = _add(ret, s);
			}
		}

		return ret;
	}

	private String _multi(String num, int cc, int zeros,
			Map<Integer, String> cache) {
		if (!cache.containsKey(cc)) {
			StringBuilder ret = new StringBuilder();

			int carried = 0;
			for (int i = num.length() - 1; i >= 0; i--) {
				int ccc = num.charAt(i) - '0';
				int m = ccc * cc + carried;
				ret.insert(0, m % 10);
				carried = m / 10;
			}

			if (carried != 0) {
				ret.insert(0, carried);
			}
			cache.put(cc, ret.toString());
		}

		StringBuilder sb = new StringBuilder(cache.get(cc));
		if (sb.length() > 1 || sb.charAt(0) != '0') {
			for (int j = 0; j < zeros; j++) {
				sb.append('0');
			}
		}

		return sb.toString();
	}

	private String _add(String num1, String num2) {
		StringBuilder ret = new StringBuilder();
		int carried = 0;
		for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
			int n1 = i >= 0 ? (num1.charAt(i) - '0') : 0;
			int n2 = j >= 0 ? (num2.charAt(j) - '0') : 0;
			int s = n1 + n2 + carried;
			ret.insert(0, s % 10);
			carried = s / 10;
		}
		if (carried > 0) {
			ret.insert(0, carried);
		}
		return ret.toString();
	}
}
