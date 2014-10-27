package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-
 * characters/
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * For example, the longest substring without repeating letters for "abcabcbb"
 * is "abc", which the length is 3. For "bbbbb" the longest substring is "b",
 * with the length of 1.
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {

		int max = 0;
		int start = 0;
		int positions[] = new int[256];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (positions[c] != 0) {

				// update the max length
				int len = i - start;
				if (len > max) {
					max = len;
				}

				// clean up the positions from start to positions[c]
				for (; start < positions[c]; start++) {
					positions[s.charAt(start)] = 0;
				}
			}
			positions[c] = i + 1;
		}

		int last = s.length() - start;
		return Math.max(max, last);
	}

	public int lengthOfLongestSubstring_(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int length = s.length();
		java.util.Map<Character, Integer> positions = new java.util.HashMap<Character, Integer>();
		int lastStartPosition = 0;
		int globalMaxLength = 0;
		int now = 0;

		while (now < length) {
			char nowChar = s.charAt(now);
			if (positions.containsKey(nowChar)) {

				int lastPosition = positions.get(nowChar);

				if (lastPosition >= lastStartPosition) {

					int localMaxLength = now - lastStartPosition;

					if (localMaxLength > globalMaxLength) {
						globalMaxLength = localMaxLength;
					}

					char nextChar = s.charAt(lastPosition + 1);
					if (nextChar == nowChar) {
						lastStartPosition = now;
					} else {
						lastStartPosition = positions.get(nextChar);
					}
				}
			}

			positions.put(nowChar, now);
			now++;
		}

		int localMaxLength = now - lastStartPosition;
		if (localMaxLength > globalMaxLength) {
			globalMaxLength = localMaxLength;
		}

		return globalMaxLength;
	}
}
