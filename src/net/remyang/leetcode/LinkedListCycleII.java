package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/linked-list-cycle-ii/
 * 
 *         Given a linked list, return the node where the cycle begins. If there
 *         is no cycle, return null.
 * 
 *         Follow up: Can you solve it without using extra space?
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null) {
			fast = fast.next; // fast moves 1
			if (fast != null) {
				slow = slow.next; // slow moves 1
				fast = fast.next; // fast moves 1 more
				if (fast == slow) { // compare fast and slow
					break;
				}
			}
		}
		if (fast == null) {
			return null;
		}

		slow = head;
		while (fast != slow) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}
