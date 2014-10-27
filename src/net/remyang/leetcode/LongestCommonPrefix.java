package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/longest-common-prefix/
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];

		StringBuilder sb = new StringBuilder();

		int j = 0;
		boolean match = true;
		while (j < strs[0].length() && match) {
			char c = strs[0].charAt(j);
			for (int i = 1; i < strs.length; i++) {
				String s = strs[i];
				if (j >= s.length() || c != s.charAt(j)) {
					match = false;
					break;
				}
			}

			if (match) {
				sb.append(c);
			}

			j++;
		}

		return sb.toString();
	}
}
