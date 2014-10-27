package net.remyang.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 *
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);

			while (!stack.isEmpty()) {
				TreeNode now = stack.pop();
				ret.add(now.val);
				if (now.right != null)
					stack.push(now.right);
				if (now.left != null)
					stack.push(now.left);
			}
		}

		return ret;
	}
}
