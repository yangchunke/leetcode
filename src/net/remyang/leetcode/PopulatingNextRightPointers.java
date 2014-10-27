package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointers {
	public void connect(TreeLinkNode root) {

		if (root == null)
			return;

		TreeLinkNode currHead = root;
		TreeLinkNode newHead = null;
		TreeLinkNode newTail = null;

		while (currHead.left != null) {

			if (newHead == null) {
				newHead = currHead.left;
			} else {
				newTail.next = currHead.left;
			}

			currHead.left.next = currHead.right;
			newTail = currHead.right;
			currHead = currHead.next;

			if (currHead == null) {
				currHead = newHead;
				newHead = null;
				newTail = null;
			}
		}
	}

}
