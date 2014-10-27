package net.remyang.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/permutations/
 *
 *         Given a collection of numbers, return all possible permutations.
 * 
 *         For example, [1,2,3] have the following permutations: [1,2,3],
 *         [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {

	public static void main(String[] args) {
		Permutations c = new Permutations();
		List<List<Integer>> ret = c.permute(new int[] { 1, 2, 2 });
		for (List<Integer> l : ret) {
			for (int i : l) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}

	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num != null) {
			List<Integer> partial = new ArrayList<Integer>();
			boolean used[] = new boolean[num.length];
			permute(num, used, partial, ret);
		}
		return ret;
	}

	private void permute(int[] num, boolean used[], List<Integer> partial,
			List<List<Integer>> ret) {
		if (partial.size() == num.length) {
			ret.add(new ArrayList<Integer>(partial));
		} else {
			for (int i = 0; i < num.length; i++) {
				if (used[i] == false) {
					used[i] = true;
					partial.add(num[i]);
					permute(num, used, partial, ret);
					used[i] = false;
					partial.remove(partial.size() - 1);
				}
			}
		}
	}

}
