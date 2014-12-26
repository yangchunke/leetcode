package net.remyang.leetcode;

public class PlusOne {

	public static void main(String[] args) {
		PlusOne c = new PlusOne();
		Utilities.printIntArray(c.plusOne(new int[]{0}));
		Utilities.printIntArray(c.plusOne(new int[]{9}));
		Utilities.printIntArray(c.plusOne(new int[]{1,0}));
	}

	public int[] plusOne(int[] digits) {
		boolean carried = true;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + (carried ? 1 : 0);
			if (sum >= 10) {
				digits[i] = sum - 10;
				carried = true;
			} else {
				digits[i] = sum;
				carried = false;
			}
		}
		if (carried) {
			int[] ret = new int[digits.length + 1];
			ret[0] = 1;
			for (int i = 0; i < digits.length; i++) {
				ret[i + 1] = digits[i];
			}
			return ret;
		} else {
			return digits;
		}
	}
}
