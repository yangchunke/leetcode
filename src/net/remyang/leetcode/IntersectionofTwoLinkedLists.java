package net.remyang.leetcode;

/**
 * 
 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:       a1 -> a2
                 \
                  -> c1 -> c2-> c3 
                 /              
B: b1 -> b2 -> b3

begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

 *
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		// get the tail of A
		ListNode tailA = headA;
		while (tailA.next != null) {
			tailA = tailA.next;
		}

		// connect tail of A with head of B
		tailA.next = headB;

		// find the start of the loop, or the intersection point.
		ListNode ret = this.findStartOfLoop(headA);

		// reset tail of A
		tailA.next = null;

		return ret;
	}

	private ListNode findStartOfLoop(ListNode headA) {

		// circle detection using fast and slow pointers
		ListNode fast = headA;
		ListNode slow = headA;
		do {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		} while (fast != null && fast != slow);

		if (fast == null) {
			// no circle
			return null;
		}

		// reset slow to the head, and iterate through both slow and fast until
		// they meet, and that is the start of the loop.
		slow = headA;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}
