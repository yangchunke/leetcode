package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers {
	int _total = 0;

	public int sumNumbers(TreeNode root) {
		if (root != null) {
			_sumNumbers(root, 0);
		}
		return _total;
	}

	private void _sumNumbers(TreeNode node, int fromRoot) {
		int val = fromRoot * 10 + node.val;
		if (node.left == null && node.right == null) {
			_total += val;
		} else {
			if (node.left != null) {
				_sumNumbers(node.left, val);
			}
			if (node.right != null) {
				_sumNumbers(node.right, val);
			}
		}
	}
}
