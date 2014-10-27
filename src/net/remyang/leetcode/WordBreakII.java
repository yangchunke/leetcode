package net.remyang.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/word-break-ii/
 *
 *         Given a string s and a dictionary of words dict, add spaces in s to
 *         construct a sentence where each word is a valid dictionary word.
 * 
 *         Return all such possible sentences.
 * 
 *         For example, given s = "catsanddog", dict = ["cat", "cats", "and",
 *         "sand", "dog"].
 * 
 *         A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> dict) {
		Map<Integer, List<String>> indexToListMap = new HashMap<Integer, List<String>>();
		return wordBreak(s, 0, dict, indexToListMap);
	}

	private List<String> wordBreak(String s, int fromIndex, Set<String> dict,
			Map<Integer, List<String>> indexToListMap) {
		if (!indexToListMap.containsKey(fromIndex)) {
			List<String> list = new ArrayList<String>();

			for (String d : dict) {
				if (s.startsWith(d, fromIndex)) {
					if (fromIndex + d.length() == s.length()) {
						list.add(d);
					} else {
						List<String> subList = wordBreak(s,
								fromIndex + d.length(), dict, indexToListMap);
						for (String subStr : subList) {
							list.add(d + " " + subStr);
						}
					}
				}
			}

			indexToListMap.put(fromIndex, list);
		}
		return indexToListMap.get(fromIndex);
	}
}
