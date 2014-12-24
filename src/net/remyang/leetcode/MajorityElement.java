package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/majority-element/
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than |_ n/2 _| times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 */
public class MajorityElement {

	private static boolean linear = true;

	public static void main(String[] args) {
		MajorityElement c = new MajorityElement();
		System.out.println(c.majorityElement(new int[] { -1, 1, 1, 1, 2, 1 }));
		System.out
				.println(c.majorityElement(new int[] { 1, 1, 1, 2, 2, 2, 2 }));
		System.out.println(c.majorityElement(new int[] { 1, 1, 2, 2, 2 }));
	}

	public int majorityElement(int[] num) {
		return linear ? this.moore(num) : this.sorting(num);
	}

	private int sorting(int[] num) {
		java.util.Arrays.sort(num);
		return num[num.length / 2];
	}

	// http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
	private int moore(int[] num) {
		int cnt = 1;
		int candidate = num[0];
		for (int i = 1; i < num.length; i++) {
			if (num[i] == candidate) {
				cnt++;
			} else {
				cnt--;
				if (cnt == 0) {
					cnt = 1;
					candidate = num[i];
				}
			}
		}
		return candidate;
	}
}
