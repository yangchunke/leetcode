package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 *
 */
public class SwapNodesinPairs {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null;
		ListNode curr = head;
		ListNode next = curr.next;

		while (curr != null && next != null) {
			if (prev == null) {
				head = next;
			} else {
				prev.next = next;
			}

			curr.next = next.next;
			next.next = curr;

			prev = curr;

			curr = curr.next;
			next = curr == null ? null : curr.next;
		}

		return head;
	}

}
