package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 *
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return (depth(root) != Integer.MIN_VALUE);
	}

	private int depth(TreeNode node) {

		if (node == null) {
			return 0;
		}

		int left = depth(node.left);
		if (left == Integer.MIN_VALUE) {
			return left;
		}

		int right = depth(node.right);
		if (right == Integer.MIN_VALUE) {
			return right;
		}

		if (left - right > 1 || right - left > 1) {
			return Integer.MIN_VALUE;
		}

		return (left > right) ? (left + 1) : (right + 1);
	}
}
