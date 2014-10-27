package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 *
 */
public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		return _sortedListToBST(head, null);
	}

	private TreeNode _sortedListToBST(ListNode head, ListNode tail) {

		if (head == tail)
			return null;

		ListNode middle = getMiddle(head, tail);
		TreeNode parent = new TreeNode(middle.val);

		parent.left = _sortedListToBST(head, middle);
		parent.right = _sortedListToBST(middle.next, tail);
		return parent;
	}

	private ListNode getMiddle(ListNode head, ListNode tail) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != tail) {
			fast = fast.next;
			if (fast != tail) {
				slow = slow.next;
				fast = fast.next;
			}
		}

		return slow;
	}

}
