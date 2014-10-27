/**
 * Longest Palindromic Substring
 */
package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/longest-palindromic-substring/
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 *
 */
public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		int T = s.length();
		int N = T;
		String ret = null;
		while (N > 0 && ret == null) {
			for (int start = 0; start <= T - N; start++) {
				int e = start + N;
				if (this.isPalindrome(s, start, e - 1)) {
					ret = s.substring(start, e);
					break;
				}
			}
			N--;
		}
		return ret;
	}

	private boolean isPalindrome(String str, int s, int e) {
		boolean ret = true;

		while (s < e) {
			if (str.charAt(s) != str.charAt(e)) {
				ret = false;
				break;
			}
			s++;
			e--;
		}

		return ret;
	}

}
