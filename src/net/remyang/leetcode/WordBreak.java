package net.remyang.leetcode;

import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-break/
 *
 *         Given a string s and a dictionary of words dict, determine if s can
 *         be segmented into a space-separated sequence of one or more
 *         dictionary words.
 * 
 *         For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 *         Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
		short used[] = new short[s.length()];
		for (int i = 0; i < s.length(); i++) {
			used[i] = 0;
		}
		return this.canBreak(s, 0, dict, used);
	}

	private boolean canBreak(String s, int offset, Set<String> dict,
			short[] used) {

		if (offset == s.length()) {
			return true;
		}

		if (used[offset] == 0) {
			for (String k : dict) {
				if (s.startsWith(k, offset)) {
					if (this.canBreak(s, offset + k.length(), dict, used)) {
						used[offset] = 1;
						return true;
					}
				}
			}
			used[offset] = -1;
			return false;
		}

		return used[offset] == 1 ? true : false;
	}
}
