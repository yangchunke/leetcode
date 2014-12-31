package net.remyang.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://oj.leetcode.com/problems/binary-search-tree-iterator/
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 */
public class BSTIterator {
	private Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

	public BSTIterator(TreeNode root) {
		intoStack(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return stack.size() > 0;
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		intoStack(node.right);
		return node.val;
	}

	private void intoStack(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}
