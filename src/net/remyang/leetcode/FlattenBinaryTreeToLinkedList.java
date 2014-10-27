package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 
	Given a binary tree, flatten it to a linked list in-place.
	
	For example,
	Given
	
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	The flattened tree should look like:
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6 
 */
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		if (root != null) {
			_flatten(root, null);
		}
	}

	private TreeNode _flatten(TreeNode now, TreeNode lastVisited) {

		if (lastVisited != null) {
			lastVisited.left = null;
			lastVisited.right = now;
		}

		lastVisited = now;
		TreeNode left = now.left;
		TreeNode right = now.right;
		if (left != null)
			lastVisited = _flatten(left, lastVisited);
		if (right != null)
			lastVisited = _flatten(right, lastVisited);

		return lastVisited;
	}
}
