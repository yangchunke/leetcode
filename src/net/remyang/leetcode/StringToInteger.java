package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/string-to-integer-atoi/
 *
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * spoilers alert... click to show requirements for atoi.
 * 
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus
 * sign followed by as many numerical digits as possible, and interprets them as
 * a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {

	public static void main(String[] args) {
		StringToInteger c = new StringToInteger();
		System.out.println(c.atoi("- 1"));
		System.out.println(c.atoi("a "));
		System.out.println(c.atoi("+1234e"));
		System.out.println(c.atoi("-2147483648"));
		System.out.println(c.atoi("2147483648"));
	}

	public int atoi(String str) {

		int ret = 0;
		boolean signEncountered = false;
		boolean numEncountered = false;
		boolean neg = false;
		for (int idx = 0; idx < str.length(); idx++) {
			char c = str.charAt(idx);

			if (c >= '0' && c <= '9') {
				numEncountered = true;
				int nextDigit = c - '0';
				if (this.overflow(ret, nextDigit)) {
					return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
				ret = ret * 10 - (c - '0');
			} else if (numEncountered || signEncountered) {
				break;
			} else if (c == '+' || c == '-') {
				signEncountered = true;
				neg = c == '-';
			} else if (c != ' ') {
				break;
			}
		}

		return neg ? ret : -ret;
	}

	private boolean overflow(int val, int nextDigit) {
		final int threadshold = Integer.MIN_VALUE / 10;
		if (val < threadshold)
			return true;
		if (val == threadshold)
			return nextDigit >= 8;
		return false;
	}
}
