package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {
		ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
		c.buildTree(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return _buildTree(preorder, inorder, 0, preorder.length, 0,
				inorder.length);
	}

	private TreeNode _buildTree(int[] preorder, int[] inorder, int preStart,
			int preEnd, int inStart, int inEnd) {
		if (preEnd <= preStart || inEnd <= inStart) {
			return null;
		}

		TreeNode parent = new TreeNode(preorder[preStart]);

		int inParent = 0;
		for (int i = inStart; i < inEnd; i++) {
			if (inorder[i] == parent.val) {
				inParent = i;
				break;
			}
		}

		int leftInStart = inStart;
		int leftInEnd = inParent;
		int rightInStart = inParent + 1;
		int rightInEnd = inEnd;

		int leftPreStart = preStart + 1;
		int leftPreEnd = leftPreStart + leftInEnd - leftInStart;
		int rightPreStart = preEnd - rightInEnd + rightInStart;
		int rightPreEnd = preEnd;

		parent.left = _buildTree(preorder, inorder, leftPreStart, leftPreEnd,
				leftInStart, leftInEnd);
		parent.right = _buildTree(preorder, inorder, rightPreStart,
				rightPreEnd, rightInStart, rightInEnd);

		return parent;
	}

}
