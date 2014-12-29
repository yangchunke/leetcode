package net.remyang.leetcode;

public class ValidPalindrome {

	public static void main(String[] args) {
		ValidPalindrome c = new ValidPalindrome();
		System.out.println(c.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(c.isPalindrome("race a car"));
		System.out.println(c.isPalindrome(""));
		System.out.println(c.isPalindrome("A"));
		System.out.println(c.isPalindrome("1a2"));
		System.out.println(c.isPalindrome(" apG0i4maAs::sA0m4i0Gp0"));
		System.out.println(c.isPalindrome(".,"));
	}

	public boolean isPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return true;
		}

		int _s = 0;
		int _e = s.length() - 1;

		do {
			int ns = this.findPos(s, _s, _e, 1);
			int ne = this.findPos(s, _e, _s, -1);
			
			if (ns>=ne){
				return true;
			}

			if (!isSame(s.charAt(ns), s.charAt(ne))) {
				return false;
			}

			_s = ns + 1;
			_e = ne - 1;
		} while (_s < _e);

		return true;
	}

	private int findPos(String s, int _s, int _e, int _o) {
		while (_s != _e && !isAlphanumeric(s.charAt(_s))) {
			_s += _o;
		}
		return _s;
	}

	private boolean isAlphanumeric(char c) {
		return isAlphabet(c) || isDigit(c);
	}

	private boolean isAlphabet(char c) {
		if (c >= 'A' && c <= 'Z') {
			return true;
		} else if (c >= 'a' && c <= 'z') {
			return true;
		}
		return false;
	}

	private boolean isDigit(char c) {
		return (c >= '0' && c <= '9');
	}

	private int delta(char c) {
		if (c >= 'A' && c <= 'Z') {
			return c - 'A';
		} else if (c >= 'a' && c <= 'z') {
			return c - 'a';
		}
		return -1;
	}

	private boolean isSame(char c1, char c2) {
		if (c1 == c2) {
			return true;
		} else if (isAlphabet(c1) && isAlphabet(c2)) {
			return delta(c1) == delta(c2);
		}
		return false;
	}
}
