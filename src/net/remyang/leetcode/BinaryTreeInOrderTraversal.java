package net.remyang.leetcode;

import java.util.*;

/**
 * 
 * https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 
	Given a binary tree, return the in-order traversal of its nodes' values.
	
	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,3,2].
	
	Note: Recursive solution is trivial, could you do it iteratively?
	
	confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
	
	
	OJ's Binary Tree Serialization:
	The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
	
	Here's an example:
	   1
	  / \
	 2   3
	    /
	   4
	    \
	     5
	The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".

 */
public class BinaryTreeInOrderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			pushLeft(stack, root);
			while (!stack.isEmpty()) {
				TreeNode now = stack.pop();
				ret.add(now.val);
				if (now.right != null) {
					pushLeft(stack, now.right);
				}
			}
		}
		return ret;
	}

	private void pushLeft(Stack<TreeNode> stack, TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}
