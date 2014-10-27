package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/permutation-sequence/
 *
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {

	public static void main(String[] args) {
		PermutationSequence c = new PermutationSequence();
		System.out.println(c.getPermutation(3, 3));
	}

	private int K = 0;
	private String ret;

	public String getPermutation(int n, int k) {
		K = k;
		boolean[] occupied = new boolean[n];
		StringBuilder sb = new StringBuilder();
		getPermutation(n, occupied, sb);
		return ret;
	}

	private boolean getPermutation(int n, boolean[] occupied, StringBuilder sb) {
		boolean found = false;
		for (int i = 0; i < n; i++) {
			if (occupied[i] == false) {
				occupied[i] = true;
				sb.append((i + 1));
				if (getPermutation(n, occupied, sb)) {
					return true;
				}
				occupied[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		if (sb.length() == n) {
			K--;
			if (K == 0) {
				ret = sb.toString();
				found = true;
			}
		}
		return found;
	}
}
