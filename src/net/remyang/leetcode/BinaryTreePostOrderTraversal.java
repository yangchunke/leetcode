package net.remyang.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/binary-tree-postorder-traversal/

	Given a binary tree, return the postorder traversal of its nodes' values.
	
	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [3,2,1].
	
	Note: Recursive solution is trivial, could you do it iteratively?

 */
public class BinaryTreePostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();

		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();

			stack.push(root);

			while (!stack.isEmpty()) {

				TreeNode now = stack.pop();
				ret.add(0, now.val);

				if (now.left != null) {
					stack.push(now.left);
				}
				if (now.right != null) {
					stack.push(now.right);
				}
			}
		}

		return ret;
	}
}
