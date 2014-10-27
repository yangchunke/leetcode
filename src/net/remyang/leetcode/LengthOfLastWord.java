package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/length-of-last-word/
 * 
 *         Given a string s consists of upper/lower-case alphabets and empty
 *         space characters ' ', return the length of last word in the string.
 * 
 *         If the last word does not exist, return 0.
 * 
 *         Note: A word is defined as a character sequence consists of non-space
 *         characters only.
 * 
 *         For example, Given s = "Hello World", return 5.
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		LengthOfLastWord c = new LengthOfLastWord();
		System.out.println(c.lengthOfLastWord("a "));
	}

	public int lengthOfLastWord(String s) {
		int ret = 0;
		boolean lastWordEncountered = false;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				if (lastWordEncountered)
					break;
			} else {
				lastWordEncountered = true;
				ret++;
			}
		}
		return ret;
	}

}
