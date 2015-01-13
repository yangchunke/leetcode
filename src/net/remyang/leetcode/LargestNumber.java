package net.remyang.leetcode;

public class LargestNumber {

	public static void main(String[] args) {
		LargestNumber c = new LargestNumber();
		System.out.println(c.largestNumber(new int[] { 824, 938, 1399, 5607,
				6973, 5703, 9609, 4398, 8247 }));
		System.out.println(c.largestNumber(new int[] { 121, 12 }));
		System.out.println(c.largestNumber(new int[] { 0, 0 }));
	}

	public String largestNumber(int[] num) {

		for (int i = 0; i < num.length; i++) {
			for (int j = i; j < num.length; j++) {
				String s_i = String.valueOf(num[i]);
				String s_j = String.valueOf(num[j]);
				if (compare(s_i, 0, s_i.length(), s_j, 0, s_j.length()) < 0) {
					int t = num[i];
					num[i] = num[j];
					num[j] = t;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length; i++) {
			sb.append(num[i]);
			if (i == 0 && num[i] == 0) {
				break;
			}
		}
		return sb.toString();
	}

	private int compare(String s1, int start1, int end1, String s2, int start2,
			int end2) {

		int i1 = start1;
		int i2 = start2;
		while (i1 < end1 && i2 < end2) {
			char c1 = s1.charAt(i1++);
			char c2 = s2.charAt(i2++);
			if (c1 < c2) {
				return -1;
			} else if (c1 > c2) {
				return 1;
			}
		}

		if (i1 < end1) {
			return compare(s1, i1, end1, s2, start2, end2);
		} else if (i2 < end2) {
			return compare(s1, start1, end1, s2, i2, end2);
		}

		return 0;
	}
}
